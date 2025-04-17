package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class CalculatorFragment extends Fragment {
    EditText edtFirst,edtSecond;
    Button btnCalculate;
    TextView txtResult;
    Spinner choice;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_calculator, container, false);

        edtFirst=view.findViewById(R.id.edtFirst);
        edtSecond=view.findViewById(R.id.edtSecond);
        btnCalculate=view.findViewById(R.id.btnCalculate);
        txtResult=view.findViewById(R.id.txtResult);
        choice = view.findViewById(R.id.operator);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int first_num,second_num, result;
                first_num=Integer.parseInt(edtFirst.getText().toString());
                second_num=Integer.parseInt(edtSecond.getText().toString());
                String ch = choice.getSelectedItem().toString();
                switch (ch){
                    case "Add":
                        result = first_num + second_num;
                        break;
                    case "Subtract":
                        result = first_num - second_num;
                        break;
                    case "Multiply":
                        result = first_num * second_num;
                        break;
                    case "Divide":
                        result = first_num / second_num;
                        break;
                    default:
                        result = 0;
                }
                txtResult.setText("Result="+result);
            }
        });
        return view;
    }
}

