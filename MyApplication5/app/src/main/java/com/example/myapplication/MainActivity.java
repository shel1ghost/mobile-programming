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
    EditText edtId,edtName,edtAddress;
    Button btnInsert,btnSelect,btnUpdate,btnDelete;
    TextView txtData;
    MyDbHelper myDbHelper;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        //creating object of MyDbHelper class
        myDbHelper=new MyDbHelper(this);
        edtId=findViewById(R.id.edtId);
        edtName=findViewById(R.id.edtName);
        edtAddress=findViewById(R.id.edtAddress);
        btnInsert=findViewById(R.id.btnInsert);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnSelect=findViewById(R.id.btnSelect);
        btnDelete=findViewById(R.id.btnDelete);
        txtData=findViewById(R.id.txtData);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(edtId.getText().toString());
                String name=edtName.getText().toString();
                String address=edtAddress.getText().toString();
                //calling insert function
                myDbHelper.insertData(id,name,address);
                Toast.makeText(getApplicationContext(),"Data Inserted Successfully !", Toast.LENGTH_SHORT).show();
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //retrieving data
                int id=0;
                String name="",address="";
            //calling select function
                Cursor cursor=myDbHelper.selectData();
                while (cursor.moveToNext()){
                    id=cursor.getInt(0);
                    name=cursor.getString(1);
                    address=cursor.getString(2);
                }
                //displaying data in TextView
                txtData.setText("Id="+id+"\t Name="+name+"\tAddress=" +address);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=edtId.getText().toString();
                String name=edtName.getText().toString();
                String address=edtAddress.getText().toString();
                //calling insert function
                myDbHelper.updateData(id,name,address);
                Toast.makeText(getApplicationContext(),"Data Updated Successfully !",Toast.LENGTH_SHORT).show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=edtId.getText().toString();
            //calling delete function
                myDbHelper.deleteData(id);
                Toast.makeText(getApplicationContext(),"Data Deleted Successfully !",Toast.LENGTH_SHORT).show();
            }
        });
    }
}