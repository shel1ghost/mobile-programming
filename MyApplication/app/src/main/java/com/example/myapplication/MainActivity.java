package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get widget object using findViewById
        Button btn_login = findViewById(R.id.btnLogin);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username = findViewById(R.id.txtUsername);
                String uname = username.getText().toString();
                EditText password = findViewById(R.id.txtPassword);
                String pass = password.getText().toString();
                if(uname.equals("babi") && pass.equals("root12345")){
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
                }
                Log.d("message","Welcome");
                Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_LONG).show();
            }
        });
    }
}
