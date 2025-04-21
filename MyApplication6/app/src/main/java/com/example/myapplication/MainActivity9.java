package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        if(savedInstanceState == null){
            Intent i = getIntent();
            int result = i.getIntExtra("result", 0);
            ResultFragment resultFragment = new ResultFragment();
            Bundle b = new Bundle();
            b.putInt("result", result);
            resultFragment.setArguments(b);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment1, resultFragment).commit();
        }
    }
}