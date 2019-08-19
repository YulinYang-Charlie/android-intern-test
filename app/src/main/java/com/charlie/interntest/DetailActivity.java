package com.charlie.interntest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView original;
    TextView text;
    int position;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        original = findViewById(R.id.original);
        button = findViewById(R.id.button);
        text = findViewById(R.id.detail);
        position = getIntent().getIntExtra("position", 00);
        Glide.with(original).load(Data.original[position]).into(original);

        String detail = "Name: " + Data.name[position] + "\nSeason: " + Data.season[position]
                + "\nNumber: " + Data.number[position]
                + "\nAirDate: " + Data.airdate[position] + "\nAirTime: " + Data.airtime[position]
                + "\nAirstamp: " + Data.airstamp[position] + "\nRunTime: " + Data.runtime[position]
                + "\nSummary: " + Data.summary[position] + "\n \n Click to see the website.";
        text.setText(detail);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, Web.class);
                intent.putExtra("url", Data.url[position]);
                startActivity(intent);

            }
        });


    }







}
