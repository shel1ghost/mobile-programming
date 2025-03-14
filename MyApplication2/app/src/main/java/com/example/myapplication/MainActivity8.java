package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        Button calculate_btn = findViewById(R.id.btnCalculate);
        calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText num1 = findViewById(R.id.num1);
                EditText num2 = findViewById(R.id.num2);
                int x = Integer.parseInt(num1.getText().toString());
                int y = Integer.parseInt(num2.getText().toString());
                Spinner choice = findViewById(R.id.operation);
                String selected_operation = choice.getSelectedItem().toString();
                int result;
                if(selected_operation.equals("Add")){
                    result = x + y;
                    Toast.makeText(getApplicationContext(), "Result is: "+String.valueOf(result), Toast.LENGTH_LONG).show();
                }else if(selected_operation.equals("Subtract")){
                    result = x - y;
                    Toast.makeText(getApplicationContext(), "Result is: "+String.valueOf(result), Toast.LENGTH_LONG).show();
                }else if(selected_operation.equals("Multiply")){
                    result = x * y;
                    Toast.makeText(getApplicationContext(), "Result is: "+String.valueOf(result), Toast.LENGTH_LONG).show();
                }else{
                    result = x / y;
                    Toast.makeText(getApplicationContext(), "Result is: "+String.valueOf(result), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}