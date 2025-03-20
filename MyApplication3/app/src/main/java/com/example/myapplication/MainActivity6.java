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

    Button b1, bsum;
    EditText t1,t2;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        b1=findViewById(R.id.dialogbtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity6.this);
                builder.setTitle("Calculate Sum");
                builder.setCancelable(true);
//inflate and set layout for the dialog
                LayoutInflater inflater=getLayoutInflater();
                View view=inflater.inflate(R.layout.custom_dialog,null);
                builder.setView(view);
                t1=view.findViewById(R.id.editFirst);
                t2=view.findViewById(R.id.editSecond);
                result=view.findViewById(R.id.txtresult);
                bsum=view.findViewById(R.id.sumbtn);
                bsum.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int num1=Integer.parseInt(t1.getText().toString());
                        int num2=Integer.parseInt(t2.getText().toString());
                        int sum=num1+num2;
                        result.setText("Result="+sum);
                    }
                });
                AlertDialog alert=builder.create();
                alert.show();
            }
        });
    }
}