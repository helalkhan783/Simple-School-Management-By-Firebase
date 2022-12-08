package com.example.collegeapp.ebook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeapp.R;

import java.util.List;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.EbookViewHolder> {

  private Context context;
  private List<EbookPojo> list;

    public EbookAdapter(Context context, List<EbookPojo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);

       return  new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookViewHolder holder, int position) {




       holder.ebookTv.setText(list.get(position).getTitle());
       
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent =new Intent(context,PdfActivity.class);
               intent.putExtra("pdfUrl",Uri.parse(list.get(position).getPdfUrl()));
               context.startActivity(intent);

            }
       });
       //this is for get url by the intent
       holder.ebookDownload.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse(list.get(position).getPdfUrl()));
               context.startActivity(intent);
           }
       });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  EbookViewHolder extends RecyclerView.ViewHolder {
          private ImageView ebookDownload;
          private TextView ebookTv;
        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);
            ebookDownload = itemView.findViewById(R.id.ebookdwnloadItemId);
            ebookTv = itemView.findViewById(R.id.ebookNameTvID);
        }
    }
}
