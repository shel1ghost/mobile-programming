package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        Button btn = findViewById(R.id.btnSubmit);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText name = findViewById(R.id.txtUsername);
                EditText password = findViewById(R.id.txtPassword);
                EditText address = findViewById(R.id.txtAddress);
                RadioButton male = findViewById(R.id.txtMale);
                RadioButton female = findViewById(R.id.txtFemale);
                EditText age = findViewById(R.id.age);
                DatePicker dob = findViewById(R.id.dob);
                Spinner state = findViewById(R.id.states);
                TextView result_name = findViewById(R.id.resultName);
                TextView result_password = findViewById(R.id.resultPassword);
                TextView result_address = findViewById(R.id.resultAddress);
                TextView result_gender = findViewById(R.id.resultGender);
                TextView result_age = findViewById(R.id.resultAge);
                TextView result_dob = findViewById(R.id.resultDob);
                TextView result_state = findViewById(R.id.resultState);

                result_name.setText("Name: "+name.getText().toString());
                result_password.setText("Password: "+password.getText().toString());
                result_address.setText("Address: "+address.getText().toString());
                if(male.isChecked()){
                    result_gender.setText("Gender: "+male.getText().toString());
                }else if(female.isChecked()){
                    result_gender.setText("Gender: "+female.getText().toString());
                }
                result_age.setText(age.getText().toString());
                int day = dob.getDayOfMonth();
                int month = dob.getMonth() + 1;
                int year = dob.getYear();
                String formattedDate = day + "/" + month + "/" + year;
                result_dob.setText("DOB: "+formattedDate);
                result_state.setText("State: "+state.getSelectedItem().toString());
            }
        });
    }
}