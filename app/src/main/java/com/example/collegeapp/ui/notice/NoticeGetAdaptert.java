package com.example.collegeapp.ui.notice;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.collegeapp.R;

import java.util.ArrayList;
import java.util.List;
//
//public class NoticeGetAdaptert extends RecyclerView.Adapter<NoticeGetAdaptert.NoticeViewAdapter> {
//
//    private Context context;
//    private ArrayList<FetchNoticeData> list;
//
//
//    public NoticeGetAdaptert(Context context, ArrayList<FetchNoticeData> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(context).inflate(R.layout.notice_delete_item, parent, false);
//
//        return new NoticeViewAdapter(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, int position) {
//
//        FetchNoticeData currentPossition = list.get(position);
//        holder.title.setText(currentPossition.getTitle());
//        holder.date.setText(currentPossition.getDate());
//        holder.time.setText(currentPossition.getTime());
//        try {
//            Glide.with(context).load(currentPossition.getImage()).into(holder.noticeImag);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class NoticeViewAdapter extends RecyclerView.ViewHolder {
//        private TextView date, time, title;
//        private ImageView noticeImag;
//
//        public NoticeViewAdapter(@NonNull View itemView) {
//            super(itemView);
//            title = itemView.findViewById(R.id.titleTvItemId);
//            date = itemView.findViewById(R.id.dateTvId);
//            time = itemView.findViewById(R.id.timeTvId);
//            noticeImag = itemView.findViewById(R.id.timeTvId);
//        }
//    }
//}
