package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Button btn = findViewById(R.id.btnCalculate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity6.this);
                builder.setTitle("Percentage Calculated");
                builder.setCancelable(true);
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.percentage_view, null);
                builder.setView(view);
                TextView totalMarks = view.findViewById(R.id.totalMarks);
                TextView result = view.findViewById(R.id.result);
                TextView percentage = view.findViewById(R.id.percentage);
                EditText marks1 = findViewById(R.id.firstSub);
                EditText marks2 = findViewById(R.id.secondSub);
                EditText marks3 = findViewById(R.id.thirdSub);
                EditText marks4 = findViewById(R.id.fourthSub);
                EditText marks5 = findViewById(R.id.fifthSub);
                int m1 = Integer.parseInt(marks1.getText().toString());
                int m2 = Integer.parseInt(marks2.getText().toString());
                int m3 = Integer.parseInt(marks3.getText().toString());
                int m4 = Integer.parseInt(marks4.getText().toString());
                int m5 = Integer.parseInt(marks5.getText().toString());
                float total_marks = m1+m2+m3+m4+m5;
                String marksResult = "Pass";
                int marks[] = {m1, m2, m3, m4, m5};
                for(int m: marks){
                    if(m < 40){
                        marksResult = "Fail";
                        break;
                    }
                }
                float marksPercentage = (total_marks/500.0F)*100;
                totalMarks.setText("Total marks: "+total_marks);
                result.setText("Result: "+marksResult);
                percentage.setText("Percentage: "+marksPercentage);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}