package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ResultFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        TextView txtResult = view.findViewById(R.id.result);
        Bundle b = getArguments();
        if(b != null) {
            txtResult.setText("The sum is "+b.getInt("result"));
        }
        return view;
    }
}