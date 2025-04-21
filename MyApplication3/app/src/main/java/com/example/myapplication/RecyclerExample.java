package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerExample extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_example);
        recyclerView=findViewById(R.id.recyleview);
        /*String name[]={"Tabita","Geeta","Kiran","Paras","jyoti","Harish","Pramod","Babita"};
        String Address[]={"Lalitpur","mnr","ktm","ktm","bhaktapur","Dhn","Baitadi","kirtipur"};
        int image[]={R.drawable.lord_shiva,R.drawable.lord_shiva,
                R.drawable.lord_shiva,R.drawable.lord_shiva,
                R.drawable.lord_shiva,R.drawable.lord_shiva,
                R.drawable.lord_shiva,R.drawable.lord_shiva};*/
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
        //setting Linear Layout in recycler view
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //passing array to adapter class.
        RecyclerViewAdapter adapter= new RecyclerViewAdapter(this,title,image);
        recyclerView.setAdapter(adapter);
    }
}