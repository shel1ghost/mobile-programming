package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FirstFragment extends Fragment {
    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button btn = view.findViewById(R.id.btnSend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = view.findViewById(R.id.name);
                String txt_name = name.getText().toString();
                EditText email = view.findViewById(R.id.email);
                String txt_email = email.getText().toString();
                EditText phone = view.findViewById(R.id.phone);
                String txt_phone = phone.getText().toString();
                EditText address = view.findViewById(R.id.address);
                String txt_address = address.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("name", txt_name);
                bundle.putString("email", txt_email);
                bundle.putString("phone", txt_phone);
                bundle.putString("address", txt_address);
                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment2, secondFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return view;
    }
}