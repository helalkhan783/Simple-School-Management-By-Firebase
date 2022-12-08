package com.example.collegeapp.ui.faculty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.collegeapp.R;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter> {

    private List<TeacherUploadPojo> list;
    private Context context;


    public TeacherAdapter(List<TeacherUploadPojo> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_layout_item,parent,false);
        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewAdapter holder, int position) {
       TeacherUploadPojo item = list.get(position);
       holder.nameTv.setText(item.getName());
       holder.emailTv.setText(item.getEmail());

       holder.postTv.setText(item.getPost());
        try {
            Glide.with(context).load(item.getImage()).into(holder.teacherImageView);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
     }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {
        private TextView nameTv,emailTv,postTv;
         private ImageView teacherImageView;

        public TeacherViewAdapter(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.teacherNameTv);
            emailTv = itemView.findViewById(R.id.teacherEmailTv);
            postTv = itemView.findViewById(R.id.teacherPostTv);
            teacherImageView = itemView.findViewById(R.id.teacherImageTv);
         }
    }
}
