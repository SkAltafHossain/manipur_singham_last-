package com.altaf.manipursinghamlast.ui.showResult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.altaf.manipursinghamlast.common.base.BaseFragment
import com.altaf.manipursinghamlast.common.extension.disable
import com.altaf.manipursinghamlast.common.extension.enable
import com.altaf.manipursinghamlast.common.extension.showErrorSnackBar
import com.altaf.manipursinghamlast.databinding.FragmentShowResultBinding
import com.altaf.manipursinghamlast.domain.model.LatestResultPdf
import com.altaf.manipursinghamlast.ui.showResult.viewmodel.ShowResultEvent
import com.altaf.manipursinghamlast.ui.showResult.viewmodel.ShowResultState
import com.altaf.manipursinghamlast.ui.showResult.viewmodel.ShowResultViewModel
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
        if (url.isBlank()) {
            showErrorSnackBar("Invalid PDF URL")
            return
        }
        
        if (isDownloading) return
        isDownloading = true
        
        binding.apply {
            progressBar.visibility = View.VISIBLE
            pdfView.visibility = View.GONE
            tvEmptyView.visibility = View.GONE
        }

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                // Download the PDF file
                val file = withContext(Dispatchers.IO) {
                    val urlConnection = URL(url).openConnection()
                    urlConnection.connect()
                    
                    val inputStream = urlConnection.getInputStream()
                    val file = File(requireContext().cacheDir, "temp_pdf_${System.currentTimeMillis()}.pdf")
                    val outputStream = FileOutputStream(file)
                    
                    inputStream.use { input ->
                        outputStream.use { output ->
                            input.copyTo(output)
                        }
                    }
                    file
                }
                
                // Display the PDF
                withContext(Dispatchers.Main) {
                    binding.progressBar.isVisible = false
                    binding.pdfView.visibility = View.VISIBLE
                    
                    binding.pdfView.fromFile(file)
                        .enableSwipe(true)
                        .swipeHorizontal(false)
                        .enableDoubletap(true)
                        .defaultPage(0)
                        .enableAnnotationRendering(false)
                        .password(null)
                        .scrollHandle(null)
                        .enableAntialiasing(true)
                        .spacing(0)
                        .onLoad { nbPages ->
                            // PDF is loaded
                            isDownloading = false
                        }
                        .onPageChange { page, pageCount ->
                            // Handle page change
                        }
                        .onError { t ->
                            isDownloading = false
                            showErrorSnackBar("Error loading PDF: ${t.message}")
                        }
                        .load()
                }
            } catch (e: Exception) {
                isDownloading = false
                withContext(Dispatchers.Main) {
                    binding.progressBar.isVisible = false
                    showErrorSnackBar("Error: ${e.localizedMessage ?: "Unknown error"}")
                }
            }
        }
    
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
            if(!isLoading && currentPdfIndex < pdfUrls.size) {
                btnPrev.enable()
            } else {
                btnPrev.disable()
            }

            if(!isLoading && currentPdfIndex > 0) {
                btnNext.enable()
            } else {
                btnNext.disable()
            }
        }
    }
    
    private fun showNextPdf() {
        if (currentPdfIndex > 0) {
            currentPdfIndex--
            showLoadingPdf(true)
            loadCurrentPdf()
        }
    }
    
    private fun showPreviousPdf() {
        if (currentPdfIndex < pdfUrls.size - 1) {
            currentPdfIndex++
            showLoadingPdf(true)
            loadCurrentPdf()
        }
    }
    
    private fun updateNavigationButtons() {
        binding.apply {
            if(currentPdfIndex < pdfUrls.size - 1 && !isDownloading) {
                btnPrev.enable()
            } else {
                btnPrev.disable()
            }
            if(currentPdfIndex > 0 && !isDownloading) {
                btnNext.enable()
            } else {
                btnNext.disable()
            }
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
