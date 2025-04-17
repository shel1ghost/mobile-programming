package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;

public class MainActivity3 extends AppCompatActivity {
    EditText edtId,edtName,edtAddress;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        edtId=findViewById(R.id.edtId);
        edtName=findViewById(R.id.edtName);
        edtAddress=findViewById(R.id.edtAddress);
        btnSubmit=findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volleyRequest();
            }
        });
    }
    public void volleyRequest(){
// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
//url for localhost
        String url ="http://192.168.1.95:8888/setdata.php";
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest
                (Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
//displaying response message
                                Toast.makeText(getApplicationContext(),response,
                                        Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//displaying error response message
                        Log.d("exception",error.toString());
                    }
                }){
            //sending data to server
            @Override
            protected HashMap<String,String> getParams(){
                HashMap<String,String> params = new HashMap<>();
                params.put("sid",edtId.getText().toString());
                params.put("name",edtName.getText().toString());
                params.put("address",edtAddress.getText().toString());
                return params;
            }
        };;
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}