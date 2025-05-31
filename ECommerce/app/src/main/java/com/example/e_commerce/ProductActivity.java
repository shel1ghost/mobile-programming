package com.example.e_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

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

public class ProductActivity extends AppCompatActivity {
    GridView gridView;
    List<Product> productList = new ArrayList<>();
    ProductAdapter adapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent i = getIntent();
        String category = i.getStringExtra("category");
        gridView = findViewById(R.id.gridView);
        adapter = new ProductAdapter(this, productList);
        gridView.setAdapter(adapter);
        textView = findViewById(R.id.productTitle);
        textView.setText(category.substring(0, 1).toUpperCase() + category.substring(1)+" products");
        fetchProducts(category);
    }

    private void fetchProducts(String category) {
        String url = "http://192.168.1.95:8888/get_products.php?category=" + category;
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray productsArray = response.getJSONArray("products");

                            productList.clear();
                            for (int i = 0; i < productsArray.length(); i++) {
                                JSONObject productObj = productsArray.getJSONObject(i);
                                productList.add(new Product(
                                        productObj.getString("id"),
                                        productObj.getString("name"),
                                        productObj.getInt("price"),
                                        productObj.getString("image")
                                ));
                            }

                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        queue.add(jsonObjectRequest);
    }
}