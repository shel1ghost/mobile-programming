package com.example.myapplication;
// qn 10
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        Button btn = findViewById(R.id.btnSubmit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.txtUsername);
                EditText email = findViewById(R.id.txtEmail);
                EditText address = findViewById(R.id.txtAddress);
                EditText phone = findViewById(R.id.txtPhone);
                Intent i = new Intent(MainActivity9.this, MainActivity10.class);
                i.putExtra("name", name.getText().toString());
                i.putExtra("email", email.getText().toString());
                i.putExtra("address", address.getText().toString());
                i.putExtra("phone", phone.getText().toString());
                startActivity(i);
            }
        });
    }
}