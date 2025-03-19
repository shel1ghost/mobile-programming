package com.example.myapplication;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentB} factory method to
 * create an instance of this fragment.
 */
public class FragmentB extends Fragment {
    private TextView resultTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        resultTextView = view.findViewById(R.id.textViewResult);
// Get the arguments (the numbers passed from FragmentA)
        Bundle bundle = getArguments();
        if (bundle != null) {
            String number1 = bundle.getString("number1");
            String number2 = bundle.getString("number2");
            int total = Integer.parseInt(number2) +
                    Integer.parseInt((number1));
// Display the numbers in the TextView
            resultTextView.setText("Number 1: " + number1 + "\nNumber 2: " + number2 + "\n Total is " + total);
        }
        return view;
    }
}