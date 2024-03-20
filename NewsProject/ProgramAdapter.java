package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {

    Context context;
    String[] newsList;
    String[] newsDescription;
    int[] images;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rowName;
        TextView rowDescription;
        ImageView rowImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowName = itemView.findViewById(R.id.newsTitle);
            rowDescription = itemView.findViewById(R.id.shortNewsTitle);
            rowImage = itemView.findViewById(R.id.imageView);
        }
    }

    public ProgramAdapter (Context context, String[] newsList, String[] newsDescription, int[] images){
        this.context = context;
        this.newsList = newsList;
        this.newsDescription = newsDescription;
        this.images = images;
    }

    @NonNull
    @Override
    public ProgramAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item_news, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramAdapter.ViewHolder holder, int position) {
        holder.rowName.setText(newsList[position]);
        holder.rowDescription.setText(newsDescription[position]);
        holder.rowImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return newsList.length;
    }
}
