package com.cateim.cursos.android.terremotosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val webView = findViewById<WebView>(R.id.webView)

        //
        val terremotoUrl = intent.getStringExtra("TERREMOTO_URL")

        if (terremotoUrl != null) {

            val settings = webView.settings
            settings.javaScriptEnabled = true

            webView.loadUrl(terremotoUrl)
        }

    }
}