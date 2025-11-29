package com.kerala.lastkerala.ui.showResult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.kerala.lastkerala.common.base.BaseFragment
import com.kerala.lastkerala.common.extension.showErrorSnackBar
import com.kerala.lastkerala.databinding.FragmentShowResultBinding
import com.kerala.lastkerala.domain.model.LatestResultPdf
import com.kerala.lastkerala.ui.showResult.viewmodel.ShowResultEvent
import com.kerala.lastkerala.ui.showResult.viewmodel.ShowResultState
import com.kerala.lastkerala.ui.showResult.viewmodel.ShowResultViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowResultFragment : BaseFragment<ShowResultViewModel, FragmentShowResultBinding>() {
    
    private var currentPdfIndex = 0
    private lateinit var pdfUrls: List<String>
    
    override fun getViewModelClass(): Class<ShowResultViewModel> = ShowResultViewModel::class.java

    override fun getViewBinding(
        inflater: LayoutInflater, 
        container: ViewGroup?
    ) = FragmentShowResultBinding.inflate(inflater, container, false)
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWebView()
        setupClickListeners()
        observeViewModel()
        viewModel.fetchLatestResults()
    }

    private fun setupWebView() {
        binding.webView.apply {
            settings.javaScriptEnabled = true
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
            settings.builtInZoomControls = true
            settings.displayZoomControls = false
            
            webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: android.webkit.WebView?, url: String?, favicon: android.graphics.Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    showLoadingPdf(true)
                }
                
                override fun onPageFinished(view: android.webkit.WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    showLoadingPdf(false)
                }
                
                override fun onReceivedError(
                    view: android.webkit.WebView?,
                    request: android.webkit.WebResourceRequest?,
                    error: android.webkit.WebResourceError?
                ) {
                    super.onReceivedError(view, request, error)
                    showLoadingPdf(false)
                    showError("Failed to load PDF")
                }
            }
            
            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: android.webkit.WebView, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    binding.progressBar.progress = newProgress
                    binding.progressBar.isVisible = newProgress < 100
                }
            }
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
        // Reverse the list to show latest PDF first (assuming results are ordered oldest to newest)
        pdfUrls = results.map { it.pdfUrl }.reversed()
        if (pdfUrls.isNotEmpty()) {
            currentPdfIndex = 0
            loadCurrentPdf()
            binding.apply {
                webView.visibility = View.VISIBLE
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
            showLoadingPdf(true)
            val pdfUrl = pdfUrls[currentPdfIndex]
            // Using Google Docs viewer to display PDF in WebView
            val pdfUrlWithViewer = "https://docs.google.com/viewer?url=$pdfUrl"
            binding.webView.loadUrl(pdfUrlWithViewer)
            updateNavigationButtons()
        }
    }
    
    private fun showLoadingPdf(isLoading: Boolean) {
        binding.apply {
            progressPrev.visibility = if (isLoading && currentPdfIndex > 0) View.VISIBLE else View.GONE
            progressNext.visibility = if (isLoading && currentPdfIndex < pdfUrls.size - 1) View.VISIBLE else View.GONE
            btnPrev.isEnabled = !isLoading && currentPdfIndex > 0
            btnNext.isEnabled = !isLoading && currentPdfIndex < pdfUrls.size - 1
        }
    }
    
    private fun showNextPdf() {
        if (currentPdfIndex < pdfUrls.size - 1) {
            currentPdfIndex++
            loadCurrentPdf()
        }
    }
    
    private fun showPreviousPdf() {
        if (currentPdfIndex > 0) {
            currentPdfIndex--
            loadCurrentPdf()
        }
    }
    
    private fun updateNavigationButtons() {
        binding.apply {
            btnPrev.isEnabled = currentPdfIndex > 0
            btnNext.isEnabled = currentPdfIndex < pdfUrls.size - 1
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
            webView.visibility = View.GONE
            navigationLayout.visibility = View.GONE
            tvEmptyView.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        binding.webView.destroy()
        super.onDestroyView()
        viewModel.clearEvent()
    }
}
