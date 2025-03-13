package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity13 extends AppCompatActivity {

    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        Button btnSend = findViewById(R.id.btnSend);
        EditText txtNUmber = findViewById(R.id.txtNumber);
        txtResult = findViewById(R.id.txtResult);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity13.this,MainActivity14.class);
                i.putExtra("number",Integer.parseInt(txtNUmber.getText().toString()));
                startActivityForResult(i,2);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2){
            String message = data.getStringExtra("result");
            txtResult.setText(message);
        }
    }
}