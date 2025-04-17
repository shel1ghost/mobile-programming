package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        Bundle bundle = getArguments();
        TextView name = view.findViewById(R.id.name);
        TextView email = view.findViewById(R.id.email);
        TextView phone = view.findViewById(R.id.phone);
        TextView address = view.findViewById(R.id.address);
        name.setText(bundle.getString("name"));
        email.setText(bundle.getString("email"));
        phone.setText(bundle.getString("phone"));
        address.setText(bundle.getString("address"));
        return view;
    }
}