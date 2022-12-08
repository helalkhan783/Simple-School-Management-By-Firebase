//package com.example.collegeapp.ui.notice;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import com.bumptech.glide.Glide;
//import com.example.collegeapp.R;
//import java.util.List;
//
//public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter> {
//    private Context context;
//    private List<NoticeDataUpload> list;
//
//    public NoticeAdapter(Context context, List<NoticeDataUpload> list) {
//        this.list = list;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.notice_delete_item, parent, false);
//        return new NoticeViewAdapter(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, int position) {
//        NoticeDataUpload item = list.get(position);
//        holder.date.setText(item.getDate());
//        holder.time.setText(item.getTime());//ekahne pblm ace
//        holder.title.setText(item.getTitle());
//        try {
//            if (item.getImage() != null)
//                Glide.with(context).load(item.getImage()).into(holder.img);
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class NoticeViewAdapter extends RecyclerView.ViewHolder {
//        private TextView date, time, title;
//        private ImageView img;
//
//        public NoticeViewAdapter(@NonNull View itemView) {
//            super(itemView);
//            date = itemView.findViewById(R.id.dateTvId);
//            time = itemView.findViewById(R.id.timeTvId);
//            title = itemView.findViewById(R.id.titleTvItemId);
//            img = itemView.findViewById(R.id.noticeItemImgid);
//
//
//        }
//    }
//}
