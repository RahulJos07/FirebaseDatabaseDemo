package com.gps.rahul.admin.firebasedatabasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.gps.rahul.admin.firebasedatabasedemo.Adapter.Image_Recycler_View_Adapter;
import com.gps.rahul.admin.firebasedatabasedemo.Model.FileUploadModel;

import java.util.ArrayList;
import java.util.List;

public class GettingAllImage extends AppCompatActivity {
    RecyclerView recycler_view;
    Image_Recycler_View_Adapter image_recycler_view_adapter;
    private DatabaseReference databaseReference;
    private List<FileUploadModel> imageUpload;
    ProgressBar progress_bar_recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_all_image);

        recycler_view=(RecyclerView)findViewById(R.id.recycler_view);
        recycler_view.setHasFixedSize(true);
        //image_recycler_view_adapter=new Image_Recycler_View_Adapter(caselist_detail, getApplication());
        recycler_view.setLayoutManager(new LinearLayoutManager(GettingAllImage.this));
        imageUpload=new ArrayList<>();

        progress_bar_recycler=(ProgressBar)findViewById(R.id.progress_bar_recycler);

        databaseReference= FirebaseDatabase.getInstance().getReference("ImageUpload");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                imageUpload.clear();
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren())
                {
                    FileUploadModel imageUploadBean=postSnapshot.getValue(FileUploadModel.class);
                    imageUpload.add(imageUploadBean);
                }
                image_recycler_view_adapter=new Image_Recycler_View_Adapter(GettingAllImage.this,imageUpload);
                recycler_view.setAdapter(image_recycler_view_adapter);
                progress_bar_recycler.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(GettingAllImage.this, ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                progress_bar_recycler.setVisibility(View.INVISIBLE);
            }
        });
    }
}
