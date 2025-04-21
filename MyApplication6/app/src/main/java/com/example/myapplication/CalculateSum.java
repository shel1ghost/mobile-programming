package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CalculateSum extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculate_sum, container, false);
        Button btn = view.findViewById(R.id.btnCalculate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        return view;
    }

    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Calculate Sum");
        builder.setCancelable(true);
        LayoutInflater inflater = getLayoutInflater();
        View view=inflater.inflate(R.layout.calculate_sum, null);
        builder.setView(view);
        EditText edtFirst=view.findViewById(R.id.edtFirst);
        EditText edtSecond=view.findViewById(R.id.edtSecond);
        Button btnCalculate=view.findViewById(R.id.btnCalculate);
        TextView txtResult=view.findViewById(R.id.txtResult);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int first,second, result;
                first=Integer.parseInt(edtFirst.getText().toString());
                second=Integer.parseInt(edtSecond.getText().toString());
                result=first+second;
                txtResult.setText("Result="+result);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}