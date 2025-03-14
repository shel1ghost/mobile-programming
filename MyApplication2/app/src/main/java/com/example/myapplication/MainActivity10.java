package com.example.myapplication;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String email = i.getStringExtra("email");
        String phone = i.getStringExtra("phone");
        String address = i.getStringExtra("address");
        TextView txt_name = findViewById(R.id.resultName);
        TextView txt_email = findViewById(R.id.resultEmail);
        TextView txt_phone = findViewById(R.id.resultPhone);
        TextView txt_address = findViewById(R.id.resultAddress);
        txt_name.setText("Name: "+name);
        txt_email.setText("Email: "+email);
        txt_phone.setText("Phone: "+phone);
        txt_address.setText("Address: "+address);
    }
}