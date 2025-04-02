package com.example.myapplication;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomGrid extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.custom_grid);
        gridView =findViewById(R.id.mygrid);
// creating arrays
        String[] title={
                "Shiva Mahapuran", "Shiva Mahapuran",
                "Shiva Mahapuran", "Shiva Mahapuran"};
        String[] price={
                "1800",
                "1800",
                "1800",
                "1800"
        };
        int[] image={
//Replace with different images
                R.drawable.lord_shiva,
                R.drawable.lord_shiva,
                R.drawable.lord_shiva,
                R.drawable.lord_shiva
        };
//passing arrays to constructor of MyListAdapter
        MyGridAdapter adapter=new MyGridAdapter(this,title,price,image);
        gridView.setAdapter(adapter);
    }
}