package com.example.e_commerce;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    ListView cartListView;
    List<Product> cartItems = new ArrayList<>();
    CartAdapter adapter;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cartListView);
        databaseHelper = new DatabaseHelper(this);

        // Set up ListView adapter
        adapter = new CartAdapter(this, cartItems);
        cartListView.setAdapter(adapter);

        // Fetch cart items
        loadCartItems();
        Button makeOrder = findViewById(R.id.makeOrder);
        makeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartActivity.this, PlaceOrderActivity.class);
                startActivity(i);
            }
        });
    }

    private void loadCartItems() {
        cartItems.clear();
        Cursor cursor = databaseHelper.getCartItems();

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                int price = cursor.getInt(cursor.getColumnIndexOrThrow("price"));
                cartItems.add(new Product("", name, price, ""));
            } while (cursor.moveToNext());
        }

        cursor.close();
        adapter.notifyDataSetChanged();
    }
}
