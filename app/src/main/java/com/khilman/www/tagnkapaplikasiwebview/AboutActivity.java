package com.khilman.www.tagnkapaplikasiwebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        // hubungkan dengan widge
        WebView wvTampilWeb = findViewById(R.id.wvTampilanWeb);
        wvTampilWeb.loadUrl("file:///android_asset/about.html");
    }
}
