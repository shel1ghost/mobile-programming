package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Button btn = findViewById(R.id.btnSend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num1 = findViewById(R.id.num1);
                EditText num2 = findViewById(R.id.num2);
                Intent i = new Intent(MainActivity6.this, MainActivity7.class);
                i.putExtra("num1",Integer.parseInt(num1.getText().toString()));
                i.putExtra("num2", Integer.parseInt(num2.getText().toString()));
                startActivityForResult(i, 2);
            }
        });
    }
    @Override
    public void onActivityResult(int request_code, int result_code, @Nullable Intent data){
        super.onActivityResult(request_code, result_code, data);
        if (result_code == 2){
            TextView result = findViewById(R.id.result);
            int res = data.getIntExtra("result", 1);
            result.setText("Result: "+String.valueOf(res));
        }
    }
}