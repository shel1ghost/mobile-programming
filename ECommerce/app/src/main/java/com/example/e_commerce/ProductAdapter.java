package com.example.e_commerce;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        }

        Product product = productList.get(position);
        ImageView productImage = convertView.findViewById(R.id.productImage);
        TextView productName = convertView.findViewById(R.id.productName);
        TextView productPrice = convertView.findViewById(R.id.productPrice);

        productName.setText(product.name);
        productPrice.setText("Rs. " + product.price);

        // Load image using Glide
        Glide.with(context).load("http://192.168.1.95:8888/images/" + product.image).into(productImage);

        // Click Listener to Open ProductDetailsActivity
        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetailsActivity.class);
            intent.putExtra("name", product.name);
            intent.putExtra("price", product.price);
            intent.putExtra("image", product.image);
            context.startActivity(intent);
        });

        return convertView;
    }
}

