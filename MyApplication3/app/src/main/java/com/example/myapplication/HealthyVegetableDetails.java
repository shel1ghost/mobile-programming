package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HealthyVegetableDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_vegetable_details);
        Intent i = getIntent();
        TextView title = findViewById(R.id.title);
        ImageView image = findViewById(R.id.image);
        TextView description = findViewById(R.id.description);
        title.setText(i.getStringExtra("title"));
        image.setImageResource(i.getIntExtra("image", 0));
        description.setText(i.getStringExtra("description"));
    }
}