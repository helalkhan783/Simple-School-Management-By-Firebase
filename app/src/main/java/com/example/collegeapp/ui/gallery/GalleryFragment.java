package com.example.collegeapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.example.collegeapp.ui.faculty.TeacherUploadPojo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class GalleryFragment extends Fragment {


    private RecyclerView convoRV, independentRv, otherRv;
    private DatabaseReference databaseReference,convoRef,independentRef,otherRef;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        convoRV = view.findViewById(R.id.convocationRecycler);
        independentRv = view.findViewById(R.id.indrependetRecycler);
        otherRv = view.findViewById(R.id.othersdayRecycler);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Gallery");

        getConvocation();
        getIndependent();
        getOther();


        return view;
    }

    private void getConvocation() {
        convoRef = databaseReference.child("convocatoin");
        convoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    ArrayList <String>   list = new ArrayList<>();

                    for (DataSnapshot snapData: snapshot.getChildren()){

                        String  data = String.valueOf(snapData.getValue());

                        list.add(data);
                    }
                      ImageAdapter   adapter = new ImageAdapter(getContext(),list);
                    convoRV.setLayoutManager(new GridLayoutManager(getContext(),3));
                    convoRV.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext()," "+error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });


    }


    private void getIndependent() {
        independentRef = databaseReference.child("independence day");
        independentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    ArrayList<String> list = new ArrayList<>();
                    for (DataSnapshot snapdata : snapshot.getChildren()){
                        String  data= String.valueOf(snapdata.getValue());
                        list.add(data);
                    }
                    independentRv.setLayoutManager(new GridLayoutManager(getContext(),3));
                    ImageAdapter adapter  = new ImageAdapter(getContext(),list);
                    independentRv.setAdapter(adapter);}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext()," "+error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getOther() {
        otherRef = databaseReference.child("others day");
        otherRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){}
                ArrayList<String> list = new ArrayList<>();

                for (DataSnapshot snapdata : snapshot.getChildren()){
                    String data = (String) snapdata.getValue();
                    list.add(data);
                }
                otherRv.setLayoutManager(new GridLayoutManager(getContext(),3));
                ImageAdapter adapter =new ImageAdapter(getContext(),list);
                otherRv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext()," "+error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}