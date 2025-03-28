package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        ListView listView=findViewById(R.id.mylist);
//creating string array
        String names[]= {"Ram","Shyam","Hari","Sita","Gita","Rita"};
//displaying list using ArrayAdapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.listview_items,R.id.text,names);
        listView.setAdapter(adapter);
    }
}