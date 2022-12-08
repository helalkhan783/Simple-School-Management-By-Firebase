package com.example.collegeapp.ui.notice;

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
import com.example.collegeapp.ui.gallery.FulIImageviewActivity;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.myHolder> {
    Context context;
    List<NoticeDataUpload> list;

    public CustomAdapter(Context context, List<NoticeDataUpload> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notice_delete_item, parent, false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder,  int position) {
        NoticeDataUpload currentData = list.get(position);
        holder.title.setText(currentData.getTitle());
        holder.date.setText(currentData.getDate());
        holder.time.setText(currentData.getTime());
        if (!currentData.getImage().equals(null)) {
            try {
                Glide.with(context).load(currentData.getImage()).placeholder(R.drawable.ic_launcher_background).into(holder.image);
            } catch (Exception e) {
                holder.image.setImageResource(R.drawable.ic_launcher_background);
            }
        } else {
            holder.image.setImageResource(R.drawable.ic_launcher_background);
        }

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(context,FulIImageviewActivity.class);
                intent.putExtra("image",currentData.getImage());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myHolder extends RecyclerView.ViewHolder {
        TextView title, date, time;
        ImageView image;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTvItemId);
            date = itemView.findViewById(R.id.dateTvId);
            time = itemView.findViewById(R.id.timeTvId);
            image = itemView.findViewById(R.id.noticeItemImgid);
        }
    }
}
