package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String email = i.getStringExtra("email");
        TextView txt_name = findViewById(R.id.txtName);
        TextView txt_email = findViewById(R.id.txtEmail);
        SharedPreferences prefs = getSharedPreferences("RememberMe", MODE_PRIVATE);
        boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);
        if(isLoggedIn){
            String userName = prefs.getString("username", "");
            String userEmail = prefs.getString("email", "");
            txt_name.setText(userName);
            txt_email.setText(userEmail);

        }else {
            txt_name.setText(name);
            txt_email.setText(email);
        }
    }
}