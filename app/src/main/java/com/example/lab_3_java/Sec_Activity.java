package com.example.lab_3_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Sec_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
    }

    public void nextClick(View v){
        Intent intent=new Intent(this,Third_Activity.class);
        startActivity(intent);
    }
    public void previousClick(View v){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}