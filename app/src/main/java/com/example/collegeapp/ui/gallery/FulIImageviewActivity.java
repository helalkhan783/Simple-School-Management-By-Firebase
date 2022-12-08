package com.example.collegeapp.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.collegeapp.R;
import com.github.chrisbanes.photoview.PhotoView;

public class FulIImageviewActivity extends AppCompatActivity {


    private PhotoView photoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ful_i_imageview);
        photoView = findViewById(R.id.photo_view);
       String image =  getIntent().getStringExtra("image");
        Glide.with(this).load(image).into(photoView);


    }
}