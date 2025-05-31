package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText lat1 = findViewById(R.id.latitude1);
                EditText long1 = findViewById(R.id.longitude1);
                EditText lat2 = findViewById(R.id.latitude2);
                EditText long2 = findViewById(R.id.longitude2);
                Intent i = new Intent(MainActivity4.this, MapsActivity.class);
                i.putExtra("lat1", Double.parseDouble(lat1.getText().toString()));
                i.putExtra("long1", Double.parseDouble(long1.getText().toString()));
                i.putExtra("lat2", Double.parseDouble(lat2.getText().toString()));
                i.putExtra("long2", Double.parseDouble(long2.getText().toString()));
                startActivity(i);
            }
        });
    }
}