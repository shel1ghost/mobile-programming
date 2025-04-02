package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity9 extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main9);
        listView=findViewById(R.id.mylist);
// creating arrays
        String[] title={
                "Title 1", "Title 2",
                "Title 3", "Title 4", "Title5", "Title6", "Title7", "Title8"};
        String[] description={
                "This is description 1",
                "This is description 2",
                "This is description 3",
                "This is description 4",
                "This is description 5",
                "This is description 6",
                "This is description 7",
                "This is description 8",
        };

        int[] image={
//Replace with different images
                R.drawable.lord_shiva,
                R.drawable.lord_shiva,
                R.drawable.lord_shiva,
                R.drawable.lord_shiva,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground
        };
//passing arrays to constructor of MyListAdapter
        MyListAdapter adapter=new MyListAdapter
                (this,title,description,image);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String title=adapter.title[position];
                String descrption=adapter.description[position];
                if(position==0){
                    Toast.makeText(getApplicationContext(), "Item 1 clicked!", Toast.LENGTH_LONG).show();
                }
                if(position==1){
                    Toast.makeText(getApplicationContext(), "Item 2 clicked!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}