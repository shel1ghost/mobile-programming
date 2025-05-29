package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {
    EditText edtPhone,edtName,edtEmail, edtFeedback;
    Button btnInsert,btnSelect,btnUpdate,btnDelete;
    TextView txtData;
    MyDbHelper myDbHelper;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        //creating object of MyDbHelper class
        myDbHelper=new MyDbHelper(this);
        edtPhone=findViewById(R.id.edtPhone);
        edtName=findViewById(R.id.edtName);
        edtEmail=findViewById(R.id.edtEmail);
        edtFeedback=findViewById(R.id.edtFeedback);
        btnInsert=findViewById(R.id.btnInsert);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnSelect=findViewById(R.id.btnSelect);
        btnDelete=findViewById(R.id.btnDelete);
        txtData=findViewById(R.id.txtData);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = edtPhone.getText().toString();
                String name=edtName.getText().toString();
                String email=edtEmail.getText().toString();
                String feedback=edtFeedback.getText().toString();
                //calling insert function
                myDbHelper.insertData(name,email, phone, feedback);
                Toast.makeText(getApplicationContext(),"Data Inserted Successfully !", Toast.LENGTH_SHORT).show();
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //retrieving data
                String name="",phone="", email="", feedback="";
            //calling select function
                Cursor cursor=myDbHelper.selectData();
                while (cursor.moveToNext()){
                    name=cursor.getString(0);
                    email=cursor.getString(1);
                    phone=cursor.getString(2);
                    feedback = cursor.getString(3);
                }
                //displaying data in TextView
                txtData.setText("Name="+name+"\t Email="+email+"\tPhone=" +phone+"\tFeedback="+feedback);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = edtPhone.getText().toString();
                String name=edtName.getText().toString();
                String email=edtEmail.getText().toString();
                String feedback=edtFeedback.getText().toString();
                //calling insert function
                myDbHelper.updateData(name,email, phone, feedback);
                Toast.makeText(getApplicationContext(),"Data Updated Successfully !",Toast.LENGTH_SHORT).show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = edtPhone.getText().toString();
            //calling delete function
                myDbHelper.deleteData(phone);
                Toast.makeText(getApplicationContext(),"Data Deleted Successfully !",Toast.LENGTH_SHORT).show();
            }
        });
    }
}