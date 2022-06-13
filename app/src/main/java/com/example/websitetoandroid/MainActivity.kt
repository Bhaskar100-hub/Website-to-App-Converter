package com.example.websitetoandroid

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myWebView: WebView = findViewById(R.id.web_view)
        myWebView.loadUrl("https://androidexample365.com/")
        myWebView.settings.javaScriptEnabled = true
        myWebView.webViewClient = WebViewClient()
        fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
            // Check if the key event was the Back button and if there's history
            if (keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()) {
                myWebView.goBack()
                return true
            }
            // If it wasn't the Back key or there's no web page history, bubble up to the default
            // system behavior (probably exit the activity)
            return super.onKeyDown(keyCode, event)
        }
    }
}