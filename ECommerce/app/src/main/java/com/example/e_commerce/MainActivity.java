package com.example.e_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
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

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> dataList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.productCategoryList);
        adapter = new ArrayAdapter<>(this, R.layout.product_category_items, R.id.category_name, dataList);
        listView.setAdapter(adapter);
        fetchData();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String category = adapter.getItem(position);
                Intent i = new Intent(MainActivity.this, ProductActivity.class);
                i.putExtra("category", category);
                startActivity(i);
                //Toast.makeText(MainActivity.this, category, Toast.LENGTH_SHORT).show();
            }
        });
        Button viewCartButton = findViewById(R.id.viewCartItems);
        viewCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
    private void fetchData() {
        String url = "http://192.168.1.95:8888/get_category.php"; // Adjust if using an emulator
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Extract the array from the JSON object
                            JSONArray categoriesArray = response.getJSONArray("categories");

                            dataList.clear(); // Clear old data
                            for (int i = 0; i < categoriesArray.length(); i++) {
                                dataList.add(categoriesArray.getString(i));
                            }

                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            Log.d("Issue: ", e.toString());
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