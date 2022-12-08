package com.example.collegeapp.ui.about.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.viewpager.widget.PagerAdapter;


import com.example.collegeapp.R;

import java.util.List;

public class BranchPagerAdapter extends PagerAdapter {

    private Context context;
    private List<BranchModelPojo> list;

    public BranchPagerAdapter(Context context, List<BranchModelPojo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return  view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

       View view = LayoutInflater.from(context).inflate(R.layout.branch_item_layout,container,false);

        ImageView image;
        TextView branch,description;

        image = view.findViewById(R.id.itemImage);
        branch = view.findViewById(R.id.itemBranch);
        description = view.findViewById(R.id.itemTv);
           image.setImageResource(list.get(position).getImage());
         branch.setText(list.get(position).getTitle());
        description.setText(list.get(position).getDescrption());

        container.addView(view,0);

        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    container.removeView((View) object);

     }
}
