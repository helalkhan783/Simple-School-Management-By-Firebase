package com.example.collegeapp.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.collegeapp.R;
import com.example.collegeapp.ui.faculty.TeacherUploadPojo;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewAdapter> {

    private Context context;
     private ArrayList<String> images;

    public ImageAdapter(Context context, ArrayList<String> image) {
        this.context = context;
        this.images = image;
    }

    @NonNull
    @Override
    public ImageViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.gallery_image_irtem,parent,false);
        return  new ImageViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewAdapter holder, int position) {



            if (images.get(position) == null){

                try {
                    Glide.with(context).load(images.get(position)).placeholder(R.drawable.ic_launcher_background).into(holder.imgV);
                } catch (Exception e) {
                    Glide.with(context).load(images.get(position)).placeholder(R.drawable.ic_launcher_background).into(holder.imgV);

                }

            } else {
                Glide.with(context).load(images.get(position)).into(holder.imgV);
            }


        //this code for  zooming activity send data
        holder.imgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, FulIImageviewActivity.class);
                intent.putExtra("image",images.get(position));
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ImageViewAdapter extends RecyclerView.ViewHolder {
              private   ImageView imgV;
        public ImageViewAdapter(@NonNull View itemView) {
            super(itemView);
        imgV = itemView.findViewById(R.id.gallery_image_itemId);
        }
    }

 }
