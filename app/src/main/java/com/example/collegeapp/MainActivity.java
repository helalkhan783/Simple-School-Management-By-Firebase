package com.example.collegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.collegeapp.ebook.EbookActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        init();
        //this code for bottom navigation
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        navController = Navigation.findNavController(this, R.id.frame_layout);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);


        //this code for navigation drawer
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //for option menu
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);

    }


    private void init() {
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);


    }


    //   this method for option selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return true;
    }

    // this method for  navigation drawer menu item selected
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.developer:
                Toast.makeText(MainActivity.this, "developer", Toast.LENGTH_SHORT).show();
                break;
            case R.id.vedio_ecture:
                Toast.makeText(MainActivity.this, "vedio lecture", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(MainActivity.this, "share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rate:
                Toast.makeText(MainActivity.this, "rate", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ebook:
                        startActivity(new Intent(MainActivity.this, EbookActivity.class));
                 break;
            case R.id.website:
                loadUrl();

                 break;
            case R.id.theme:
                Toast.makeText(MainActivity.this, "theme", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    private void loadUrl() {
        WebView webView = new WebView(MainActivity.this);
        webView.loadUrl("https://www.facebook.com/profile.php?id=100011015141120");
    }

    //drawer layout theke back press a jate kore apps destroy na hoy
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }
}