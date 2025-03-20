package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String email = i.getStringExtra("email");
        TextView name_view = findViewById(R.id.txtName);
        name_view.setText(name);
        Toolbar toolbar = findViewById(R.id.dashboard_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.dashboard_menu,menu);
        return true;
    }

    //handling clicks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String title = (String) item.getTitle();
        switch (title) {
            case "Profile":
                Intent i = getIntent();
                String name = i.getStringExtra("name");
                String email = i.getStringExtra("email");
                Intent profile = new Intent(Dashboard.this, Profile.class);
                profile.putExtra("name", name);
                profile.putExtra("email", email);
                startActivity(profile);
                break;
            case "Logout":
                Intent logout = new Intent(Dashboard.this, MainActivity.class);
                startActivity(logout);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}