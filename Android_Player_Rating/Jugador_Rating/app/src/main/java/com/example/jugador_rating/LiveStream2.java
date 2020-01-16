package com.example.jugador_rating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LiveStream2 extends AppCompatActivity {

    WebView cr7livesoccer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_stream2);

        cr7livesoccer = (WebView) findViewById(R.id.cr7webID);
//        WebSettings websettings = diuWeb.getSettings();
//        websettings.setJavaScriptEnabled(true);

        cr7livesoccer.getSettings().setJavaScriptEnabled(true);

        cr7livesoccer.setWebViewClient(new WebViewClient());
        cr7livesoccer.loadUrl("https://www.ronaldo7.net/");
    }
}
