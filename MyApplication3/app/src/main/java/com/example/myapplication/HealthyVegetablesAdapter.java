package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthyVegetablesAdapter extends ArrayAdapter<String> {
    Activity context;
    String[] title;
    int[] price;
    int[] image;
    public HealthyVegetablesAdapter(Activity context, String[] title, int[] price, int[] image) {
        super(context, R.layout.customgrid_items,title);
        this.context=context;
        this.title=title;
        this.price=price;
        this.image=image;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.healthy_vegetables_items, null,true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
        TextView txtDescription = (TextView) rowView.findViewById(R.id.price);
        txtTitle.setText(title[position]);
        imageView.setImageResource(image[position]);
        txtDescription.setText("Rs."+price[position]);
        return rowView;
    };
}

