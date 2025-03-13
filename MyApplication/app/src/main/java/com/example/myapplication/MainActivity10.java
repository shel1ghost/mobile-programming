package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main10);
        Log.d("Lifecycle Test", "Activity Created");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle Test", "Activity Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle Test", "Activity Resumed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle Test", "Activity Restarted");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle Test", "Activity Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle Test", "Activity Paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle Test", "Activity Destroyed");
    }
}