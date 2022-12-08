package com.example.collegeapp.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {

private RecyclerView ebookRv;
private DatabaseReference reference;
private List<EbookPojo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        this.setTitle("Ebook");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ebook");

        ebookRv = findViewById(R.id.ebookRvId);
        ebookRv.setLayoutManager(new LinearLayoutManager(EbookActivity.this));

        reference = FirebaseDatabase.getInstance().getReference().child("pdf");
        getEbook();

    }

    private void getEbook() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                if (snapshot.exists()){

                    for (DataSnapshot snapdata : snapshot.getChildren()){
                       EbookPojo data = snapdata.getValue(EbookPojo.class);

                       list.add(data);
                    }
                    EbookAdapter adapter = new EbookAdapter(EbookActivity.this,list);
                    ebookRv.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, " " +error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}