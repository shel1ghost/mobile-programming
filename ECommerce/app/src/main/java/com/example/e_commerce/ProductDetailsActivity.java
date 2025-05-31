package com.example.e_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class ProductDetailsActivity extends AppCompatActivity {
    ImageView productImage;
    TextView productName, productPrice;
    Button addToCart;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        productImage = findViewById(R.id.productImage);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
        addToCart = findViewById(R.id.addToCart);
        databaseHelper = new DatabaseHelper(this);
        // Get data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int price = intent.getIntExtra("price", 0);
        String image = intent.getStringExtra("image");

        // Set data in UI
        productName.setText(name);
        productPrice.setText("Rs. " + price);
        Glide.with(this).load("http://192.168.1.95:8888/images/" + image).into(productImage);

        // Handle "Add to Cart" button click
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = databaseHelper.addToCart(name, price);
                if (inserted) {
                    Toast.makeText(ProductDetailsActivity.this, "Added to Cart!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ProductDetailsActivity.this, "Failed to add to cart", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
