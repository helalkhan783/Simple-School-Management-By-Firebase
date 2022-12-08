package com.example.collegeapp.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {
    private RecyclerView physicsRv,chemistryRv,mathRv;
    private LinearLayout physicsNoData,chemistryNoData,mathNoData;
    private List<TeacherUploadPojo> listPhysics,listChemistry,listMath;
    private DatabaseReference databaseReference,dref;
    private TeacherAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("techer");

        // for recyclerview init
        physicsRv = view.findViewById(R.id.physicsRecyclerViewId);
        chemistryRv = view.findViewById(R.id.chemistryRecyclerViewId);
        mathRv = view.findViewById(R.id.mathRecyclerViewId);

        // for linearlayout init
        physicsNoData = view.findViewById(R.id.noPhysicsData);
        chemistryNoData = view.findViewById(R.id.noPhysicsData);
        mathNoData = view.findViewById(R.id.noMathData);
        physicsGetAndsetData();

        chemistryGetAndSet();

        mathDataGetAndSet();
  return view;

     }




    private void physicsGetAndsetData() {
        dref = databaseReference.child("Physics");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listPhysics = new ArrayList<>();
                if (!snapshot.exists()){
                    physicsNoData.setVisibility(View.VISIBLE);
                    physicsRv.setVisibility(View.GONE);
                }else {
                    physicsNoData.setVisibility(View.GONE);
                    physicsRv.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherUploadPojo data = dataSnapshot.getValue(TeacherUploadPojo.class);
                        listPhysics.add(data);
                    }
                    physicsRv.setHasFixedSize(true);
                    physicsRv.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(listPhysics, getContext());
                    physicsRv.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), ""  +error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }


    private void chemistryGetAndSet() {
        dref = databaseReference.child("Chemistry");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listChemistry = new ArrayList<>();
                if (!snapshot.exists()){
                    chemistryNoData.setVisibility(View.VISIBLE);
                    chemistryRv.setVisibility(View.GONE);
                }else {
                    chemistryNoData.setVisibility(View.GONE);
                    chemistryRv.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherUploadPojo data = dataSnapshot.getValue(TeacherUploadPojo.class);
                        listChemistry.add(data);
                    }
                    chemistryRv.setHasFixedSize(true);
                    chemistryRv.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(listChemistry,getContext());
                    chemistryRv.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), ""  +error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void mathDataGetAndSet() {
        dref = databaseReference.child("Math");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listMath = new ArrayList<>();
                if (!snapshot.exists()){
                    mathNoData.setVisibility(View.VISIBLE);
                    mathRv.setVisibility(View.GONE);
                }else {
                    mathNoData.setVisibility(View.GONE);
                    mathRv.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherUploadPojo data = dataSnapshot.getValue(TeacherUploadPojo.class);
                        listMath.add(data);
                    }

                    mathRv.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(listMath,getContext());
                    mathRv.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), ""  +error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}