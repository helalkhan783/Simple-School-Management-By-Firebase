package com.example.collegeapp.ui.about.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.collegeapp.R;
import com.example.collegeapp.ui.about.about.BranchModelPojo;
import com.example.collegeapp.ui.about.about.BranchPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchPagerAdapter adapter;
    private List<BranchModelPojo> list;
    private ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModelPojo(R.drawable.physics_ic,"Physics","The students of the department learn not only fundamental subjects such as solid state physics, nuclear physics, classical mechanics, atomic and molecular physics, quantum mechanics, statistical mechanics, electromagnetism, relativity and so on, but also get systematic training on exercises and experiments."));
        list.add(new BranchModelPojo(R.drawable.chemistry_ic,"Chemistry","The students of the department learn not only fundamental subjects such as solid state physics, nuclear physics, classical mechanics, atomic and molecular physics, quantum mechanics, statistical mechanics, electromagnetism, relativity and so on, but also get systematic training on exercises and experiments."));
        list.add(new BranchModelPojo(R.drawable.math_ic,"Math","The students of the department learn not only fundamental subjects such as solid state physics, nuclear physics, classical mechanics, atomic and molecular physics, quantum mechanics, statistical mechanics, electromagnetism, relativity and so on, but also get systematic training on exercises and experiments."));

        viewPager = view.findViewById(R.id.aboutViewPager);

        adapter = new BranchPagerAdapter(getContext(),list);
        viewPager.setAdapter(adapter);

        imageView = view.findViewById(R.id.aboutImgId);
        Glide.with(getContext()).load( "https://firebasestorage.googleapis.com/v0/b/admin-college-application.appspot.com/o/Notice%2F%5BB%40dec18f6jpg?alt=media&token=ada176ea-4f11-4f49-9f52-7e97d2b4ec0f").into(imageView);


        return  view;

    }
}