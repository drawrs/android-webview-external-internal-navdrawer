package com.khilman.www.tagnkapaplikasiwebview;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Dari sini Navigation Drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Sampai sini

        // Hubungkan Widget / Inisialisasi
        WebView wvTampilanWeb = findViewById(R.id.wvTampilanWeb);
        // tambahkan web view client
        wvTampilanWeb.setWebViewClient(new WebViewClient());

        // aktifkan fitur tambahan
        wvTampilanWeb.getSettings().setJavaScriptEnabled(true);
        wvTampilanWeb.getSettings().setDisplayZoomControls(true);
        wvTampilanWeb.getSettings().setGeolocationEnabled(true);
        wvTampilanWeb.getSettings().setSupportZoom(true);

        // tampilkan web site
        wvTampilanWeb.loadUrl("http://www.khilman.com");

    }

    @Override
    public void onBackPressed() {
        // menghandle ketika pengguna menekan back saat navigation drawer muncul
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // Menampilan menu popup / menu di pojok kanan
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // menghandle ketika menu popup di klik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // tampilin toast
            Toast.makeText(this, "menunya di klik looohhh", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            //

        } else if (id == R.id.nav_about) {
            // pindah ke activity about
            startActivity(new Intent(this, AboutActivity.class));

        } else if (id == R.id.nav_exit) {
            // Jalankan method / function
            konfirmasiKeluar();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void konfirmasiKeluar() {
        // Munculkan Alert dialog konfirmasi
        // Panggil class alert dialognya
        AlertDialog.Builder confirmExit = new AlertDialog.Builder(MainActivity.this);
        // set judul alert
        confirmExit.setTitle("Exit ?");
        // set pesan alert
        confirmExit.setMessage("Are you sure ?");
        // tampilkan positif button dngan text "Yes"
        confirmExit.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // keluar dari aplikasi / kill aplikasi dari memory sistem
                System.exit(0);
            }
        });
        // tampilkan negatif button dengan text "Cancel"
        confirmExit.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // kosongin aja nanti nutup dengan sendirinya
            }
        });
        // tampilkan alert
        confirmExit.show();
    }


}
