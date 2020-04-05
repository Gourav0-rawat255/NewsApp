package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;

public class Response extends AppCompatActivity {


    WebView webView;
    ProgressBar progressbar;
//    JavaScriptInterface JSInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.response);




        webView = findViewById(R.id.webview);
        Bundle bundle = getIntent().getExtras();
        String newurl = bundle.getString("newsurl");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(newurl);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        progressbar = findViewById(R.id.progressBar);

    }

    public class WebViewClient extends android.webkit.WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressbar.setVisibility(View.GONE);
        }
    }

}
