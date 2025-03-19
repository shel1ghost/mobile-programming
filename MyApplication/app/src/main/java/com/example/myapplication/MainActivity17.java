package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity17 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
// Load FragmentA into fragment_a_container
        if (savedInstanceState == null) {
            FragmentX fragmentX = new FragmentX();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_x_container, fragmentX).commit();
// Load FragmentB into fragment_b_container
            FragmentY fragmentY = new FragmentY();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_y_container, fragmentY).commit();
        }
    }
}