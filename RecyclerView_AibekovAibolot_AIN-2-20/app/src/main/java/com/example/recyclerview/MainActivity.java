package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.github.javafaker.Faker;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[],s2[];

    int[] images = {R.drawable.doctor1,R.drawable.doctor2,R.drawable.doctor3,
            R.drawable.doctor4,R.drawable.doctor5,R.drawable.doctor6,
            R.drawable.doctor9,R.drawable.doctor8,R.drawable.doctor7,
            R.drawable.doctor10,R.drawable.doctor11};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_doctors);

        s1 = getResources().getStringArray(R.array.names);
        s2 = getResources().getStringArray(R.array.roles);

        DoctorAdapter doctorAdapter = new DoctorAdapter(this,s1,s2,images);
        recyclerView.setAdapter(doctorAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

     }

     public void click(View view){
        Button callButton = findViewById(R.id.phoneCall);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+996555312208"));
        startActivity(intent);
     }

}