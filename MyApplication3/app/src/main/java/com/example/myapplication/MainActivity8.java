package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        GridView gridView =findViewById(R.id.mygrid);
//creating string array
        String names[]= {"Ram","Shyam","Hari","Sita","Gita"};
//displaying list using ArrayAdapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.gridview_items,R.id.text,names);
        gridView.setAdapter(adapter);
    }
}