package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        Intent i = getIntent();
        int p = i.getIntExtra("principal", 0);
        int t = i.getIntExtra("time", 0);
        int r = i.getIntExtra("rate", 0);
        float si = (p*t*r)/100;
        EditText t1 = findViewById(R.id.txtPrincipal);
        EditText t2 = findViewById(R.id.txtTime);
        EditText t3 = findViewById(R.id.txtRate);
        TextView v = findViewById(R.id.result);
        t1.setText(String.valueOf(p));
        t2.setText(String.valueOf(t));
        t3.setText(String.valueOf(r));
        v.setText("Your intrest is "+String.valueOf(si));
    }
}