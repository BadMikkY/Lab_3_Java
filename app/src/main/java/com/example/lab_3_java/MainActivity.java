package com.example.lab_3_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    cource courceObject;
    final String fname="File.txt";
    ArrayList<cource> cources=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        courceObject=new cource();
        collectionGetter();
        spinner=findViewById(R.id.spinner);
        String[] Education=new String[]{"Среднее","Среднее специальное","Высшее"};
        ArrayAdapter<CharSequence> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,Education);
        spinner.setAdapter(adapter);
    }


    public void nextButton(View v){

        Intent intent=new Intent(this,Sec_Activity.class);
        courceObject.Education=spinner.getSelectedItem().toString();



        EditText textGetter=findViewById(R.id.companyName);
        courceObject.companyName=textGetter.getText().toString();
        textGetter=findViewById(R.id.workersNumber);
        courceObject.workersNumber=Integer.parseInt(textGetter.getText().toString());


        intent.putExtra("objectCource",courceObject);
        intent.putExtra("courceList",cources);
        startActivity(intent);
    }

    public void collectionGetter(){
    GsonBuilder gsonBuilder=new GsonBuilder();
    Gson gs=gsonBuilder.create();
    try{
        File f=new File(super.getFilesDir(),fname);
        BufferedReader bw=new BufferedReader(new FileReader(f));
        if(f.length()!=0){
            cources=gs.fromJson(bw.readLine(),ArrayList.class);
        }
        else{
            cources=new ArrayList<>();
        }
    }
    catch(IOException e){
        Log.d("ExceptionLog",e.getMessage());
        }
    }
}