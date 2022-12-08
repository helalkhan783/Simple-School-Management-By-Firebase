package com.example.collegeapp.ui.notice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class NoticeFragment extends Fragment {
    private RecyclerView noticeRv;
    private DatabaseReference databaseReference;
    private List<NoticeDataUpload> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        noticeRv = view.findViewById(R.id.noticeRvId);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Notice");
        noticeRv.setLayoutManager(new LinearLayoutManager(getContext()));
        getNotice();


        return view;
    }

    private void getNotice() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    list = new ArrayList<>();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        NoticeDataUpload data = snapshot.getValue(NoticeDataUpload.class);
                        list.add(data);
                    }
              //     NoticeAdapter noticeAdapter = new NoticeAdapter(getContext(), list);
                 CustomAdapter customAdapter = new CustomAdapter(getContext(), list);
                noticeRv.setAdapter(customAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), "data not found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}