package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity16 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);
        Button b1 = findViewById(R.id.btnfirst);
        Button b2 = findViewById(R.id.btnsecond);
        LinearLayout linear =findViewById(R.id.linearlayout);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f1= new BlankFragment();
                FragmentTransaction t1= getSupportFragmentManager().beginTransaction();
                t1.replace(R.id.linearlayout,f1);
                t1.commit();
            }
        });
    }
}