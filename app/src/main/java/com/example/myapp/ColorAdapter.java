package com.example.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {
    List<Integer> color = Arrays.asList(Color.MAGENTA,Color.GREEN,Color.RED,Color.BLACK,Color.BLUE);
    @NonNull
    @Override
    public ColorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorAdapter.ViewHolder holder, int position) {
        holder.v1.setBackgroundResource(R.drawable.list_drawable);
        GradientDrawable gd = (GradientDrawable) holder.v1.getBackground();
        gd.setColor(color.get(position));
    }

    @Override
    public int getItemCount() {
        return color.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        View v1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v1 = itemView.findViewById(R.id.v1);
        }
    }
}
