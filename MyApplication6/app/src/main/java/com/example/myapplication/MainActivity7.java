package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        ListView listView = findViewById(R.id.studentsList);
        String students[] = {"Aaditya Khatri", "Aisha Joshi", "Ashmita Lamicchane", "Babi Thakur", "Bibek Baral", "Bikash Parajuli", "Diya Tamrakar", "Erika Ghimire", "Janak Trital", "Khem Raj Thapa", "Keshab Poudel", "Manas Bista", "Meraj Shrestha", "Nikesh Nepal", "Nuna Das", "Pradhuna Khatri"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.student_list_items, R.id.stdName, students);
        listView.setAdapter(adapter);
    }
}