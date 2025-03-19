package com.example.myapplication;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentA} factory method to
 * create an instance of this fragment.
 */
public class FragmentA extends Fragment {
    private EditText number1EditText, number2EditText;
    private Button sendButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
// Initialize the UI elements
        number1EditText = view.findViewById(R.id.editTextNumber1);
        number2EditText = view.findViewById(R.id.editTextNumber2);
        sendButton = view.findViewById(R.id.buttonSend);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Get the numbers entered by the user
                String number1 = number1EditText.getText().toString();
                String number2 = number2EditText.getText().toString();
// Validate input
                if (number1.isEmpty() || number2.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter both numbers", Toast.LENGTH_SHORT).show();
                } else {
// Create a bundle to pass the data to FragmentB
                    Bundle bundle = new Bundle();
                    bundle.putString("number1", number1);
                    bundle.putString("number2", number2);
// Create an instance of FragmentB
                    FragmentB fragmentB = new FragmentB();
                    fragmentB.setArguments(bundle);
// Replace FragmentA with FragmentB
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, fragmentB);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
        return view;
    }
}