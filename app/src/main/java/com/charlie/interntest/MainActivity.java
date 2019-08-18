package com.charlie.interntest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    public static TextView data;
//    public static String[] summary;
//    public static int size = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Data process = new Data();
        process.execute();
        while(Data.summary.length == 0){

        }


        RecyclerView internlist = findViewById(R.id.internlist);

        internlist.setLayoutManager(new LinearLayoutManager(this));



        internlist.setAdapter(new internAdapter());



//        data = (TextView) findViewById(R.id.data);





    }
}
