package com.location.wanandroid.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.location.base.BaseActivity
import com.location.base.BaseDaggerActivity
import com.location.wanandroid.R
import com.location.wanandroid.databinding.ActivityDetailsBinding
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebSettings
import com.tencent.smtt.sdk.WebView
import javax.inject.Inject

/**
 *
 * @author tianxiaolong
 * time：2021/2/28 5:46 PM
 * description：
 */

class DetailsActivity: BaseDaggerActivity<ActivityDetailsBinding>() {
    companion object{
        const val KEY_URL = "key_url"
    }
    override val layoutId: Int
        get() = R.layout.activity_details



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.progressBar.visibility = View.VISIBLE
        binding.webView.webChromeClient = object:WebChromeClient(){
            override fun onProgressChanged(p0: WebView?, progress: Int) {
               binding.progressBar.progress = progress
                if(progress >= 100){
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
        intent.getStringExtra(KEY_URL)?.let {
            binding.webView.loadUrl(it)
        }

        val webSetting: WebSettings = binding.webView.settings
        val mUserAgentString = webSetting.userAgentString
        webSetting.javaScriptEnabled = true
        webSetting.javaScriptCanOpenWindowsAutomatically = false
        webSetting.allowFileAccess = true
        webSetting.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        webSetting.setSupportZoom(false)
        webSetting.builtInZoomControls = false
        webSetting.useWideViewPort = true
        webSetting.loadWithOverviewMode = true
        webSetting.setAppCacheEnabled(true)
        webSetting.domStorageEnabled = true
        webSetting.setGeolocationEnabled(true)
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE)
        webSetting.pluginState = WebSettings.PluginState.ON_DEMAND
        webSetting.cacheMode = WebSettings.LOAD_DEFAULT

    }

}