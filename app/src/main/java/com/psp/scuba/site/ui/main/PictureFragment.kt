package com.psp.scuba.site.ui.main

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.psp.scuba.BaseFragment
import com.psp.scuba.R
import com.psp.scuba.site.Site
import kotlinx.android.synthetic.main.activity_site_detail_picture.*

/**
 * A placeholder fragment containing a simple view.
 */
class PictureFragment : BaseFragment() {
    companion object {
        fun newInstance(site: Site): Fragment {
            val fp = PictureFragment()
            val args = Bundle()
            args.putSerializable("site", site)
            fp.setArguments(args)
            return fp
        }
    }

    override fun onBackPressedCaptured(): Boolean {
        if (webview.canGoBack()) {
            webview.goBack()
            return true
        } else {
            return super.onBackPressedCaptured()
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val site = arguments?.getSerializable("site") as Site
        Log.e("param", site.id.toString())

        //인스타그램 페이지
        val root = inflater.inflate(R.layout.activity_site_detail_picture, container, false)
        val mWebView = root.findViewById<WebView>(R.id.webview)
        val webSettings = mWebView.settings
        webSettings.javaScriptEnabled = true
        mWebView.loadUrl(site.instagram_url)
        WebView.setWebContentsDebuggingEnabled(false)

        return root
    }
}