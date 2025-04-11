package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView=findViewById(R.id.recyclerview);
        volleyRequest();
    }

    public void volleyRequest(){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        //url for localhost
        String url ="http://192.168.1.95:8888/getdata.php";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    //displaying response string in logcat
                        Log.d("mysql_result",response);
                        decodeJSON(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //displaying error response message
                Log.d("exception",error.toString());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void decodeJSON(String response){
        try{
            ArrayList<DataModel> data=new ArrayList<>();
            JSONObject result=new JSONObject(response);
            JSONArray array=result.getJSONArray("data");
            for(int i=0;i<array.length();i++){
                //fetching each row
                JSONObject student=array.getJSONObject(i);
                int sid=student.getInt("roll_no");
                String name=student.getString("name");
                String address=student.getString("address");
                DataModel dataModel=new DataModel(sid,name,address);
                data.add(dataModel);
            }
            layoutManager=new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            MysqlRecycleviewAdapter recyclerAdapter=new MysqlRecycleviewAdapter(MainActivity2.this,data);
            recyclerView.setAdapter(recyclerAdapter);
        }catch (Exception ex){
            Log.d("Exception",ex.toString());
        }
    }
}
