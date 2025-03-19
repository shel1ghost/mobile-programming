package com.example.myapplication;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class PassingFragmentDataExample extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_fragment_data_example);
        if (savedInstanceState == null) {
            FragmentA fragmentA = new FragmentA();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentA).commit();
        }
    }
}
