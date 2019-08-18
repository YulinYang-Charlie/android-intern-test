package com.charlie.interntest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class internAdapter extends RecyclerView.Adapter<internAdapter.internViewHolder> {
//    String[] medium;
//    String[] original;
//    String[] summary;

    public internAdapter(){
//        this.summary = summary;
//        System.out.println(summary[0]);
    }

    @Override
    public internViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new internViewHolder(view);
    }

    @Override
    public void onBindViewHolder(internViewHolder holder, int position) {
        String summary1 = Data.summary[position];
        holder.summary.setText(summary1);


    }

    @Override
    public int getItemCount() {
        return Data.summary.length;
    }

    public class internViewHolder extends RecyclerView.ViewHolder{
        TextView summary;

        public internViewHolder(View itemView) {
            super(itemView);
            summary = itemView.findViewById(R.id.summary);
        }
    }
}
