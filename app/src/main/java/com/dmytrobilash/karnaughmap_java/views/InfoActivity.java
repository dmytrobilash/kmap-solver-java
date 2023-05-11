package com.dmytrobilash.karnaughmap_java.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dmytrobilash.karnaughmap_java.R;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class InfoActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        webView = findViewById(R.id.webView);
        
        webView.setWebViewClient(new WebViewClient());
        loadRandomWikiPage();
    }

    private void loadRandomWikiPage() {
        webView.loadUrl("https://en.wikipedia.org/wiki/Karnaugh_map");
    }
}