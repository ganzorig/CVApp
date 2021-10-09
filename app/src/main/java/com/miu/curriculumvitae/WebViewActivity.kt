package com.miu.curriculumvitae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

import kotlinx.android.synthetic.main.activity_web_view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        title = "WebView"

        intent.getStringExtra("url")?.let { webview.loadUrl(it) }


    }


//    fun getUrlFromIntent(view: View) {
//        val url = "http://www.google.com"
//        val intent = Intent(Intent.ACTION_VIEW)
//        intent.data = Uri.parse(url)
//        startActivity(intent)
//    }


}