package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        Button calculate_btn = findViewById(R.id.btnCalculate);
        Button calculate_next_btn = findViewById(R.id.btnNext);
        TextView result = findViewById(R.id.result);
        calculate_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText t1 = findViewById(R.id.txtPrincipal);
                EditText t2 = findViewById(R.id.txtTime);
                EditText t3 = findViewById(R.id.txtRate);
                if(TextUtils.isEmpty(t1.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter principal.", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(t2.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter time.", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(t3.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter rate.", Toast.LENGTH_SHORT).show();
                }else {
                    int p = Integer.parseInt(t1.getText().toString());
                    int t = Integer.parseInt(t2.getText().toString());
                    int r = Integer.parseInt(t3.getText().toString());
                    float si = (p * t * r) / 100;
                    result.setText("Your intrest is " + si);
                }
            }
        });
        calculate_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity11.this, MainActivity12.class);
                EditText t1 = findViewById(R.id.txtPrincipal);
                EditText t2 = findViewById(R.id.txtTime);
                EditText t3 = findViewById(R.id.txtRate);
                if(TextUtils.isEmpty(t1.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter principal.", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(t2.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter time.", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(t3.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter rate.", Toast.LENGTH_SHORT).show();
                }else {
                    int p = Integer.parseInt(t1.getText().toString());
                    int t = Integer.parseInt(t2.getText().toString());
                    int r = Integer.parseInt(t3.getText().toString());
                    i.putExtra("principal", p);
                    i.putExtra("time", t);
                    i.putExtra("rate", r);
                    startActivity(i);
                }
            }
        });
    }
}