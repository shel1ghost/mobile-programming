package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity14 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        Button sendBack = findViewById(R.id.btnSendBack);
        TextView data = findViewById(R.id.lblInputedNumber);
        Intent i = getIntent();
        Integer number = i.getIntExtra("number",0);

        data.setText("Number is " + number);
        Integer resultdata = 1;
        for (int j = 1; j <= number; j++) {
            resultdata *= j;
        }
        String result = "Result is " + resultdata;
        sendBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("result",result);
                setResult(2,i);
                finish();
            }
        });
    }
}