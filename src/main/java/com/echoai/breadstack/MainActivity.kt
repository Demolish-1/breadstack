package com.echoai.breadstack

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.echoai.breadstack.ui.theme.BreadStackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BreadStackTheme {
                WebViewScreen()
            }
        }
    }
}

@Composable
fun WebViewScreen() {
    // Compose wrapper for Android WebView
    AndroidView(factory = { context ->
        WebView(context).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient() // ensures links open in the WebView
            loadUrl("file:///android_asset/index.html")
        }
    })
}
