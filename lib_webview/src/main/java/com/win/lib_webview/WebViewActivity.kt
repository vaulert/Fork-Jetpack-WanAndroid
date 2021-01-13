package com.win.lib_webview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.net.http.SslError
import android.os.Bundle
import android.webkit.*
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.win.lib_base.view.activity.BaseActivity
import com.win.lib_base.viewModel.EmptyViewModel
import com.win.lib_webview.databinding.ActivityWebviewBinding

/**
 * Create by liwen on 2020/5/26
 */
class WebViewActivity : BaseActivity<EmptyViewModel, ActivityWebviewBinding>() {

    @Autowired
    lateinit var title: String

    @Autowired
    lateinit var url: String

    override fun getLayoutResId(): Int = R.layout.activity_webview

    override fun initData() = Unit

    override fun initView() {
        mViewBinding.mCollect.setOnClickListener {
            mViewBinding.mCollect.imageTintList =
                ColorStateList.valueOf(resources.getColor((R.color.imageView_tint)))
        }
    }

    companion object {
        fun start(context: Context, title: String, url: String) {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("url", url)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        StatusBarKt.fitSystemBar(this)
        initActionBar()
        initWebView()
    }

    private fun initActionBar() {
        mViewBinding.mTvTitle.text = title
        mViewBinding.mIvBack.setOnClickListener { finish() }
    }

    @SuppressLint("JavascriptInterface")
    private fun initWebView() {
        val settings = mViewBinding.mWebView.settings
        settings.allowContentAccess = true
        settings.domStorageEnabled = true
        settings.allowFileAccess = true
        settings.javaScriptEnabled = true

        mViewBinding.mWebView.addJavascriptInterface(this, "wan")
        mViewBinding.mWebView.webChromeClient = object : WebChromeClient() {}
        mViewBinding.mWebView.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler?,
                error: SslError?
            ) {
                handler?.proceed()
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
        mViewBinding.mWebView.loadUrl(url)
    }
}