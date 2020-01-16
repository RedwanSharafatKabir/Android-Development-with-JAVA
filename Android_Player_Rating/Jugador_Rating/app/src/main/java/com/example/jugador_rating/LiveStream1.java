package com.example.jugador_rating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LiveStream1 extends AppCompatActivity {

    WebView livesoccer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_stream1);

        livesoccer = (WebView) findViewById(R.id.livesoccerwebID);
//        WebSettings websettings = diuWeb.getSettings();
//        websettings.setJavaScriptEnabled(true);

        livesoccer.getSettings().setJavaScriptEnabled(true);

        livesoccer.setWebViewClient(new WebViewClient());
        livesoccer.loadUrl("https://www.livesoccertv.com/");
    }
}
