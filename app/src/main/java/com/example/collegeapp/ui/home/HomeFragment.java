 package com.example.collegeapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.collegeapp.R;
 import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;



public class HomeFragment extends Fragment {

    private SliderLayout slider;
    private LinearLayout mapLayout;
    private ImageView mapImg;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        slider = view.findViewById(R.id.silider);
        mapLayout = view.findViewById(R.id.map_layout);
        slider.setIndicatorAnimation(IndicatorAnimations.FILL);
        slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        slider.setScrollTimeInSec(1);


        setSliderView();
        mapLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                Uri gmmIntentUri = Uri.parse("geo:0, 0?q=Jagannath University In  Dhaka");

                //Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri).setPackage("com.google.android.apps.maps");
                 startActivity(new Intent(Intent.ACTION_VIEW, gmmIntentUri).setPackage("com.google.android.apps.maps"));
            }
        });

        return view;


    }
    private void setSliderView() {
        for (int i = 0; i < 5; i++) {
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admin-college-application.appspot.com/o/Gallery%2F%5BB%40ab50858jpg?alt=media&token=a0121f83-8c7e-49d8-93a5-38c072b2dc47");
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admin-college-application.appspot.com/o/Gallery%2F%5BB%40ab50858jpg?alt=media&token=a0121f83-8c7e-49d8-93a5-38c072b2dc47");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admin-college-application.appspot.com/o/Gallery%2F%5BB%40ab50858jpg?alt=media&token=a0121f83-8c7e-49d8-93a5-38c072b2dc47");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admin-college-application.appspot.com/o/Gallery%2F%5BB%40ab50858jpg?alt=media&token=a0121f83-8c7e-49d8-93a5-38c072b2dc47");
                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admin-college-application.appspot.com/o/Gallery%2F%5BB%40ab50858jpg?alt=media&token=a0121f83-8c7e-49d8-93a5-38c072b2dc47");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
                    slider.addSliderView(sliderView);
        }
    }
}