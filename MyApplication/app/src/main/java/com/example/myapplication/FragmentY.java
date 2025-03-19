package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentY extends Fragment {
    private TextView resultTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_y, container, false);
        resultTextView = view.findViewById(R.id.textViewResult);
// Get the arguments (the numbers passed from FragmentA)
        Bundle bundle = getArguments();
        if (bundle != null) {
            String number1 = bundle.getString("number1");
            String number2 = bundle.getString("number2");
// Display the numbers in the TextView
            resultTextView.setText("Number 1: " + number1 + "\nNumber 2: " + number2);
        }
        return view;
    }
}