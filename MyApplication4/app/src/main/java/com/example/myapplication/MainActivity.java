package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    //handling clicks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        String title = (String) item.getTitle();
        switch(title)
        {
            case "Login":
                Intent login = new Intent(MainActivity.this, Login.class);
                startActivity(login);
                break;
            case "Register":
                Intent register = new Intent(MainActivity.this, Register.class);
                startActivity(register);
                break;
            case "About":
                Intent about = new Intent(MainActivity.this, About.class);
                startActivity(about);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}