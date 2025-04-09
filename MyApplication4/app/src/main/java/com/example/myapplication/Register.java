package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {
    MyDbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        helper=new MyDbHelper(this);
        EditText username = findViewById(R.id.txtUsername);
        EditText password = findViewById(R.id.txtPassword);
        EditText email = findViewById(R.id.txtEmail);
        Button register = findViewById(R.id.btnRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String passwd = password.getText().toString();
                String eml = email.getText().toString();
                helper.insertData(uname, passwd, eml);
                Toast.makeText(getApplicationContext(),"Registered Successfully !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}