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
import androidx.fragment.app.FragmentTransaction;

public class MainActivity12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        ListView listView = findViewById(R.id.listView);
        String[] names = {"Babi", "Erika", "Ashmita", "Simran"};
        int[] roll = {4, 7, 3, 27};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.listview_items, R.id.txtName, names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentFragment f = new StudentFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("roll", roll[position]);
                bundle.putString("name", names[position]);
                f.setArguments(bundle);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.linearLayout, f);
                ft.commit();
            }
        });
    }
}