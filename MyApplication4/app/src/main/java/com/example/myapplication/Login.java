package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
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
    MyDbHelper db_helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db_helper=new MyDbHelper(this);
        Button btn_login = findViewById(R.id.btnLogin);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input_email = findViewById(R.id.txtEmail);
                EditText input_password = findViewById(R.id.txtPassword);
                String name="", password="", email="";
                Cursor cursor=db_helper.selectData(input_email.getText().toString(), input_password.getText().toString());
                while (cursor.moveToNext()){
                    name=cursor.getString(0);
                    password=cursor.getString(1);
                    email=cursor.getString(2);
                }
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