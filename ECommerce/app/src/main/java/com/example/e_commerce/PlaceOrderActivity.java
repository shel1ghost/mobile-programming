package com.example.e_commerce;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderActivity extends AppCompatActivity {
    EditText username, contactNumber;
    DatabaseHelper databaseHelper;
    ListView cartListView;
    List<Product> cartItems = new ArrayList<>();
    CartAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        Button confirmOrder = findViewById(R.id.confirmOrder);
        username = findViewById(R.id.username);
        contactNumber = findViewById(R.id.contactNumber);
        databaseHelper = new DatabaseHelper(this);
        cartListView = findViewById(R.id.cartListView);
        adapter = new CartAdapter(this, cartItems);
        cartListView.setAdapter(adapter);

        loadCartItems();
        confirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder(username.getText().toString(), contactNumber.getText().toString());
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
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        } else {
            Log.e("CartAdapterError", "Adapter is NULL when trying to update UI!");
        }
    }
    private void placeOrder(String username, String contact) {
        String url = "http://192.168.1.95:8888/place_order.php"; // API URL

        try {
            // Convert cart items to JSON
            JSONArray cartArray = new JSONArray();
            for (Product item : cartItems) {
                JSONObject cartItem = new JSONObject();
                cartItem.put("name", item.name);
                cartItem.put("price", item.price);
                cartArray.put(cartItem);
            }

            // Create JSON object with username & contact details
            JSONObject postData = new JSONObject();
            postData.put("username", username);
            postData.put("contact", contact);
            postData.put("cart", cartArray);

            // Send POST request
            RequestQueue queue = Volley.newRequestQueue(this);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.POST, url, postData,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("OrderResponse", response.toString());
                            Toast.makeText(PlaceOrderActivity.this, "Order placed successfully!", Toast.LENGTH_SHORT).show();
                            databaseHelper.clearCart();// Optional: Clear cart after order
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("VolleyError", "Error: " + error.getMessage());
                            Toast.makeText(PlaceOrderActivity.this, "Failed to place order", Toast.LENGTH_SHORT).show();
                        }
                    });

            queue.add(jsonObjectRequest);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}