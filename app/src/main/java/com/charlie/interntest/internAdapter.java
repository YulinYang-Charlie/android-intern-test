package com.charlie.interntest;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.Glide;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class internAdapter extends RecyclerView.Adapter<internAdapter.internViewHolder> {
//    String[] medium;
//    String[] original;
//    String[] summary;
    int size;

    public internAdapter(){
//        this.summary = summary;
//        System.out.println(summary[0]);
//        this.size = size;
    }

    @Override
    public internViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new internViewHolder(view);
    }

    @Override
    public void onBindViewHolder(internViewHolder holder, int position) {
        while(Data.summary[position]== null){

        }
        String medium1 = Data.medium[position];
        Glide.with(holder.image.getContext()).load(medium1).into(holder.image);

        String summary1 = Data.summary[position];
        holder.summary.setText(summary1);





    }

    @Override
    public int getItemCount() {

        return Data.summary.length;
    }

    public class internViewHolder extends RecyclerView.ViewHolder{
        TextView summary;
        ImageView image;

        public internViewHolder(View itemView) {
            super(itemView);
            summary = itemView.findViewById(R.id.summary);
            image = itemView.findViewById(R.id.image);
        }
    }
}
