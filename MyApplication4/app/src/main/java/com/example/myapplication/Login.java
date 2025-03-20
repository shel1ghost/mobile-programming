package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn_login = findViewById(R.id.btnLogin);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = "shellghst@gmail.com";
                String password = "HackTheBox123";
                String name = "Babi Thakur";
                EditText input_email = findViewById(R.id.txtEmail);
                EditText input_password = findViewById(R.id.txtPassword);
                if(input_email.getText().toString().equals(email) && input_password.getText().toString().equals(password)){
                    Intent dashboard = new Intent(Login.this, Dashboard.class);
                    dashboard.putExtra("name", name);
                    dashboard.putExtra("email", email);
                    startActivity(dashboard);
                }else{
                    Toast.makeText(Login.this, "Incorrect username or password!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}