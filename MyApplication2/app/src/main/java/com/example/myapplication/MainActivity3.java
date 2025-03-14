package com.example.myapplication;
//Question no 6
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button btn = findViewById(R.id.btnWelcome);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText txt = findViewById(R.id.txtName);
                String data = txt.getText().toString();
                Intent i = new Intent(MainActivity3.this, MainActivity4.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
    }
}