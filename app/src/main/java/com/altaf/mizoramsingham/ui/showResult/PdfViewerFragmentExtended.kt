package com.altaf.manipursingham.ui.showResult

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.altaf.manipursingham.R
import java.io.File
import java.io.IOException

class PdfViewerFragmentExtended : Fragment(), OnPageErrorListener, OnLoadCompleteListener {
    
    private var pdfView: PDFView? = null
    private var currentUri: Uri? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        arguments?.let {
            currentUri = it.getParcelable("uri")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pdf_viewer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pdfView = view.findViewById(R.id.pdfView)
        
        currentUri?.let { uri ->
            openPdfFromUri(uri)
        }
    }
    
    private fun openPdfFromUri(uri: Uri) {
        try {
            // Copy the file to cache if needed
            val inputStream = requireContext().contentResolver.openInputStream(uri)
            val tempFile = File(requireContext().cacheDir, "temp_${System.currentTimeMillis()}.pdf")
            inputStream?.use { input ->
                tempFile.outputStream().use { output ->
                    input.copyTo(output)
                }
            }
            
            // Load the PDF file with null safety
            pdfView?.fromFile(tempFile)?.defaultPage(0)?.enableAnnotationRendering(true)?.onLoad(this)
                ?.onPageError(this)?.scrollHandle(DefaultScrollHandle(requireContext()))?.spacing(10)
                ?.load()
                ?: run {
                Log.e("PdfViewerFragment", "PDFView is null")
            }
                
        } catch (e: IOException) {
            Log.e("PdfViewerFragment", "Error loading PDF", e)
        } catch (e: Exception) {
            Log.e("PdfViewerFragment", "Unexpected error", e)
        }
    }
    
    override fun loadComplete(nbPages: Int) {
        // PDF loaded successfully
    }
    
    override fun onPageError(page: Int, t: Throwable?) {
        Log.e("PdfViewerFragment", "Error loading page: $page", t)
    }
    
    companion object {
        fun newInstance(uri: Uri): PdfViewerFragmentExtended {
            return PdfViewerFragmentExtended().apply {
                arguments = Bundle().apply {
                    putParcelable("uri", uri)
                }
            }
        }
    }
}
