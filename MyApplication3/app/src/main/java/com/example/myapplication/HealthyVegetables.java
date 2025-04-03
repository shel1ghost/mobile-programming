package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HealthyVegetables extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_healthy_vegetables);
        gridView =findViewById(R.id.mygrid);
// creating arrays
        String[] title={
                "Beetroot", "Drumstick",
                "Brocolli", "Peas"};
        String[] description={
                "Beetroot is rich in nutrients like iron, vitamin C, maganese, etc.",
                "Drumstick is good source of vitamins, minerals and antioxidants.",
                "Brocolli is good source of vitamin K which is important for blood cloting and bone health",
                "Peas are nutritious cereal rich in protiens"
        };
        int[] image={
                R.drawable.beetroot,
                R.drawable.drumstick,
                R.drawable.brocolli,
                R.drawable.peas
        };

        HealthyVegetablesAdapter adapter=new HealthyVegetablesAdapter(this,title,description,image);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(HealthyVegetables.this, HealthyVegetableDetails.class);
                i.putExtra("title", title[position]);
                i.putExtra("image", image[position]);
                i.putExtra("description", description[position]);
                startActivity(i);
            }
        });
    }
}