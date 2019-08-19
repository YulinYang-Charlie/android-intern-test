package com.charlie.interntest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView original;
    TextView text;
    int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        original = findViewById(R.id.original);
        text = findViewById(R.id.detail);
        position = getIntent().getIntExtra("position", 00);
        Glide.with(original).load(Data.original[position]).into(original);

        String detail = "Name: " + Data.name[position] + "\nSeason: " + Data.season[position]
                + "\nNumber: " + Data.number[position]
                + "\nAirDate: " + Data.airdate[position] + "\nAirTime: " + Data.airtime[position]
                + "\nAirstamp: " + Data.airstamp[position] + "\nRunTime: " + Data.runtime[position]
                + "\nSummary: " + Data.summary[position];
        text.setText(detail);


    }
}
