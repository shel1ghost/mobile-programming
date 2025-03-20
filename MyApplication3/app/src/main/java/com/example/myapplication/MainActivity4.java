package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button btn = findViewById(R.id.context);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pm=new PopupMenu(MainActivity4.this,btn);
                pm.inflate(R.menu.popup_menu);
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String title = (String) item.getTitle();
                        switch(title)
                        {
                            case "Item_1":
                                Toast.makeText(MainActivity4.this,"item1 is clicked", Toast.LENGTH_LONG).show();
                                break;
                            case "Item_2":
                                Toast.makeText(MainActivity4.this,"item2 is clicked", Toast.LENGTH_LONG).show();
                                break;
                            case "Item_3":
                                Toast.makeText(MainActivity4.this,"item3 is clicked", Toast.LENGTH_LONG).show();
                                break;
                            default:
                                return false;
                        }
                        return true;
                    }
                });
                pm.show();
            }
        });
    }
}

