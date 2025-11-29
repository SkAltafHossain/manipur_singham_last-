package com.kerala.lastkerala.ui.showResult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.github.barteksc.pdfviewer.listener.OnErrorListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.kerala.lastkerala.common.base.BaseFragment
import com.kerala.lastkerala.common.extension.showErrorSnackBar
import com.kerala.lastkerala.databinding.FragmentShowResultBinding
import com.kerala.lastkerala.domain.model.LatestResultPdf
import com.kerala.lastkerala.ui.showResult.viewmodel.ShowResultEvent
import com.kerala.lastkerala.ui.showResult.viewmodel.ShowResultState
import com.kerala.lastkerala.ui.showResult.viewmodel.ShowResultViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.net.URL

@AndroidEntryPoint
class ShowResultFragment : BaseFragment<ShowResultViewModel, FragmentShowResultBinding>() {
    
    private var currentPdfIndex = 0
    private var pdfUrls: List<String> = emptyList()
    private var isDownloading = false
    
    override fun getViewModelClass(): Class<ShowResultViewModel> = ShowResultViewModel::class.java

    override fun getViewBinding(
        inflater: LayoutInflater, 
        container: ViewGroup?
    ) = FragmentShowResultBinding.inflate(inflater, container, false)
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        observeViewModel()
        viewModel.fetchLatestResults()
    }
    
    private fun loadPdf(url: String) {
        if (isDownloading) return
        
        binding.apply {
            progressBar.visibility = View.VISIBLE
            pdfView.visibility = View.GONE
            tvEmptyView.visibility = View.GONE
        }
        
        isDownloading = true
        
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            try {
                val input = URL(url).openStream()
                val tempFile = File(requireContext().cacheDir, "temp_${System.currentTimeMillis()}.pdf")
                tempFile.outputStream().use { output ->
                    input.copyTo(output)
                }
                
                withContext(Dispatchers.Main) {
                    displayPdf(tempFile)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showError("Failed to load PDF: ${e.message}")
                }
            } finally {
                isDownloading = false
            }
        }
    }
    
    private fun displayPdf(pdfFile: File) {
        try {
            binding.pdfView.fromFile(pdfFile)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false)
                .spacing(10)
                .onLoad { nbPages ->
                    binding.progressBar.visibility = View.GONE
                    binding.pdfView.visibility = View.VISIBLE
                    updateNavigationButtons()
                }
                .onError { error ->
                    showError("Error loading PDF: $error")
                }
                .load()
        } catch (e: Exception) {
            showError("Error displaying PDF: ${e.message}")
        }
    }

    private fun setupClickListeners() {
        binding.apply {
            btnPrev.setOnClickListener { showPreviousPdf() }
            btnNext.setOnClickListener { showNextPdf() }
        }
    }
    
    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                when (state) {
                    is ShowResultState.Loading -> showLoading(true)
                    is ShowResultState.Success -> {
                        showLoading(false)
                        showPdfList(state.results)
                    }
                    is ShowResultState.Error -> {
                        showLoading(false)
                        showError(state.message)
                    }
                    ShowResultState.Empty -> {
                        showLoading(false)
                        showEmptyView()
                    }
                }
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.uiEvent.collect { event ->
                when (event) {
                    is ShowResultEvent.ShowError -> showError(event.message)
                    else -> Unit
                }
                viewModel.clearEvent()
            }
        }
    }
    
    private fun showPdfList(results: List<LatestResultPdf>) {
        pdfUrls = results.map { it.pdfUrl }
        if (pdfUrls.isNotEmpty()) {
            currentPdfIndex = 0
            loadPdf(pdfUrls[currentPdfIndex])
            binding.apply {
                pdfView.visibility = View.VISIBLE
                navigationLayout.visibility = View.VISIBLE
                tvEmptyView.visibility = View.GONE
            }
            updateNavigationButtons()
        } else {
            showEmptyView()
        }
    }
    
    private fun loadCurrentPdf() {
        if (pdfUrls.isNotEmpty() && currentPdfIndex in pdfUrls.indices) {
            loadPdf(pdfUrls[currentPdfIndex])
        }
    }
    
    private fun showLoadingPdf(isLoading: Boolean) {
        binding.apply {
            btnPrev.isEnabled = !isLoading && currentPdfIndex > 0
            btnNext.isEnabled = !isLoading && currentPdfIndex < pdfUrls.size - 1
        }
    }
    
    private fun showNextPdf() {
        if (currentPdfIndex < pdfUrls.size - 1) {
            currentPdfIndex++
            showLoadingPdf(true)
            loadCurrentPdf()
        }
    }
    
    private fun showPreviousPdf() {
        if (currentPdfIndex > 0) {
            currentPdfIndex--
            showLoadingPdf(true)
            loadCurrentPdf()
        }
    }
    
    private fun updateNavigationButtons() {
        binding.apply {
            btnPrev.isEnabled = currentPdfIndex > 0 && !isDownloading
            btnNext.isEnabled = currentPdfIndex < pdfUrls.size - 1 && !isDownloading
        }
    }
    
    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading
    }
    
    private fun showError(message: String) {
        showErrorSnackBar(message)
    }
    
    private fun showEmptyView() {
        binding.apply {
            pdfView.visibility = View.GONE
            navigationLayout.visibility = View.GONE
            tvEmptyView.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        binding.pdfView.recycle()
        super.onDestroyView()
        viewModel.clearEvent()
    }
}
