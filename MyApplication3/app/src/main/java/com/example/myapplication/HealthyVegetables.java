package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HealthyVegetables extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_healthy_vegetables);
        gridView =findViewById(R.id.mygrid);
// creating arrays
        String[] title={
                "Beetroot", "Drumstick",
                "Brocolli", "Peas", "Cauliflower", "Mushroom", "Beetroot", "Drumstick", "Brocolli", "Peas", "Cauliflower", "Mushroom"};
        int[] image={
                R.drawable.beetroot,
                R.drawable.drumstick,
                R.drawable.brocolli,
                R.drawable.peas,
                R.drawable.cauliflower,
                R.drawable.mushroom,
                R.drawable.beetroot,
                R.drawable.drumstick,
                R.drawable.brocolli,
                R.drawable.peas,
                R.drawable.cauliflower,
                R.drawable.mushroom
        };

        int[] prices = {60, 75, 80, 90, 120, 50, 60, 75, 80, 90, 120, 50 };

        HealthyVegetablesAdapter adapter=new HealthyVegetablesAdapter(this,title,prices,image);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Intent i = new Intent(HealthyVegetables.this, HealthyVegetableDetails.class);
                i.putExtra("title", title[position]);
                i.putExtra("image", image[position]);
                i.putExtra("description", description[position]);
                startActivity(i);*/
                AlertDialog.Builder builder = new AlertDialog.Builder(HealthyVegetables.this);
                builder.setTitle(title[position]);
                builder.setTitle("Details");
                builder.setCancelable(true);
                LayoutInflater inflater = getLayoutInflater();
                View v = inflater.inflate(R.layout.healthy_vegetables_dialog, null);
                builder.setView(v);
                TextView t = v.findViewById(R.id.title);
                TextView d = v.findViewById(R.id.price);
                ImageView i = v.findViewById(R.id.image);
                t.setText(title[position]);
                d.setText("Rs."+prices[position]);
                i.setImageResource(image[position]);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}