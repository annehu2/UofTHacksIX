package com.example.checked.screenings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.checked.R;

public class q4 extends Fragment {

    public q4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_q4, container, false);

        ImageView prev = root.findViewById(R.id.prev);
        ImageView next = root.findViewById(R.id.next);
        RadioButton yes = root.findViewById(R.id.radioButton);
        RadioButton no = root.findViewById(R.id.radioButton2);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setVisibility(View.INVISIBLE);
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setVisibility(View.VISIBLE);
            }
        });
        prev.setOnClickListener(this::prev);
        next.setOnClickListener(this::next);

        return root;
    }

    protected void prev(View view) {
        Navigation.findNavController(view).navigate(R.id.action_q4_to_q3);
    }

    protected void next(View view) {
        Navigation.findNavController(view).navigate(R.id.action_q4_to_q5);
    }
}