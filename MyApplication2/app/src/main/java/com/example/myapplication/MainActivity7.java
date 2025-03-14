package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Intent i = getIntent();
        int num1 = i.getIntExtra("num1", 1);
        int num2 = i.getIntExtra("num2", 1);
        EditText first = findViewById(R.id.num1);
        EditText second = findViewById(R.id.num2);
        first.setText(String.valueOf(num1));
        second.setText(String.valueOf(num2));
        Button send_back = findViewById(R.id.btnCalculate);
        send_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner choice = findViewById(R.id.operation);
                String selected_operation = choice.getSelectedItem().toString();
                Intent i = new Intent();
                int result;
                if(selected_operation.equals("Add")){
                    result = num1 + num2;
                    i.putExtra("result", result);
                    setResult(2,i);
                    finish();
                }else if(selected_operation.equals("Subtract")){
                    result = num1 - num2;
                    i.putExtra("result", result);
                    setResult(2,i);
                    finish();
                }else if(selected_operation.equals("Multiply")){
                    result = num1 * num2;
                    i.putExtra("result", result);
                    setResult(2,i);
                    finish();
                }else{
                    result = num1 / num2;
                    i.putExtra("result", result);
                    setResult(2,i);
                    finish();
                }
            }
        });
    }
}