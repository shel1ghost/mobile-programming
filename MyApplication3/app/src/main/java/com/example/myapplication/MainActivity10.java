package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity10 extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        String[] title={
                "Beetroot", "Drumstick",
                "Brocolli", "Peas", "Cauliflower", "Mushroom", "Beetroot", "Drumstick", "Brocolli", "Peas", "Cauliflower", "Mushroom"};
        String[] description={
                "Beetroot is rich in nutrients like iron, vitamin C, maganese, etc.",
                "Drumstick is good source of vitamins, minerals and antioxidants.",
                "Brocolli is good source of vitamin K which is important for blood cloting and bone health",
                "Peas are nutritious cereal rich in protiens",
                "Cauliflower is a good source of vitamins C and K, dietary fiber, and antioxidants",
                "Rich in Vitamin D, supporting heart health, boosting immunity, and promoting brain function",
                "Beetroot is rich in nutrients like iron, vitamin C, maganese, etc.",
                "Drumstick is good source of vitamins, minerals and antioxidants.",
                "Brocolli is good source of vitamin K which is important for blood cloting and bone health",
                "Peas are nutritious cereal rich in protiens",
                "Cauliflower is a good source of vitamins C and K, dietary fiber, and antioxidants",
                "Rich in Vitamin D, supporting heart health, boosting immunity, and promoting brain function"
        };
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
        listView = findViewById(R.id.mylist);
        VegetablesListAdapter adapter=new VegetablesListAdapter(this,title,description,image);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity10.this);
                builder.setTitle(title[position]);
                builder.setTitle("Details");
                builder.setCancelable(true);
                LayoutInflater inflater = getLayoutInflater();
                View v = inflater.inflate(R.layout.healthy_vegetables_dialog, null);
                builder.setView(v);
                TextView t = v.findViewById(R.id.title);
                TextView d = v.findViewById(R.id.description);
                ImageView i = v.findViewById(R.id.image);
                t.setText(title[position]);
                d.setText(description[position]);
                i.setImageResource(image[position]);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}