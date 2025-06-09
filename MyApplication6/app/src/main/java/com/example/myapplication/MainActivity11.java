package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        String[] names = {"Babi", "Erika", "Ashmita", "Simran"};
        int[] roll = {4, 7, 3, 27};
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.listview_items, R.id.txtName, names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity11.this);
                LayoutInflater inflater = getLayoutInflater();
                View v = inflater.inflate(R.layout.listview_items, null);
                TextView txtName = v.findViewById(R.id.txtName);
                TextView rollNo = v.findViewById(R.id.rollNo);
                txtName.setText("Name: "+names[position]);
                rollNo.setText("Roll No: "+roll[position]);
                builder.setView(v);
                AlertDialog alert = builder.create();
                alert.show();

            }
        });
    }
}