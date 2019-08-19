package com.charlie.interntest;

import android.content.Context;
import android.content.Intent;
import com.bumptech.glide.Glide;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class internAdapter extends RecyclerView.Adapter<internAdapter.internViewHolder> {

    Context ctx;


    public internAdapter(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public internViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new internViewHolder(view, ctx);
    }

    @Override
    public void onBindViewHolder(internViewHolder holder, int position) {
        while(Data.summary[position]== null){

        }
        String medium1 = Data.medium[position];
        Glide.with(holder.image.getContext()).load(medium1).into(holder.image);

        String summary1 = Data.summary[position];
        holder.summary.setText("Name: " + Data.name[position] + "\n" + summary1
                               + "\n \nClick to see more details");





    }

    @Override
    public int getItemCount() {

        return Data.summary.length;
    }

    public class internViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView summary;
        ImageView image;
        Context ctx;

        public internViewHolder(View itemView, Context ctx) {
            super(itemView);
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            summary = itemView.findViewById(R.id.summary);
            image = itemView.findViewById(R.id.image);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(ctx, DetailActivity.class);
            intent.putExtra("position", position);
            this.ctx.startActivity(intent);


        }
    }
}
