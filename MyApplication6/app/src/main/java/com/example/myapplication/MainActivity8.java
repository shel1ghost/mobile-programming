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

public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        Button btn = findViewById(R.id.btnSum);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText num1 = findViewById(R.id.edtFirst);
                EditText num2 = findViewById((R.id.edtSecond));
                int firstNumber = Integer.parseInt(num1.getText().toString());
                int secondNumber = Integer.parseInt(num2.getText().toString());
                int sum = firstNumber + secondNumber;
                Intent i = new Intent(MainActivity8.this, MainActivity9.class);
                i.putExtra("result", sum);
                startActivity(i);
            }
        });
    }
}