package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Activity context;
    int [] image;
    String [] title;
    public RecyclerViewAdapter(Activity context,String[]title, int[]image) {
        this.context = context;
        this.title = title;
        this.image = image;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View listitem=layoutInflater.inflate(R.layout.recycler_view_items,parent,false);
        ViewHolder viewHolder=new ViewHolder(listitem);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtname.setText(title[position]);
        //holder.txtAddress.setText(address[position]);
        holder.imageView.setImageResource(image[position]);
    }
    @Override
    public int getItemCount() {
        return title.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname, txtAddress;
        ImageView imageView;
        public ViewHolder(View itemview)
        {
            super(itemview);
            txtname=itemview.findViewById(R.id.name);
            //txtAddress=itemview.findViewById(R.id.address);
            imageView=itemview.findViewById(R.id.rimage);

        }
    }
}