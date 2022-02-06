package com.example.checked.screenings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.example.checked.R;

public class q2 extends Fragment {

    public q2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_q2, container, false);

        ImageView prev = root.findViewById(R.id.prev);
        ImageView next = root.findViewById(R.id.next);
        prev.setOnClickListener(this::prev);
        next.setOnClickListener(this::next);

        CheckBox none = root.findViewById(R.id.checkBox6);
        none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(none.isChecked()){
                    next.setVisibility(View.VISIBLE);
                } else {
                    next.setVisibility(View.INVISIBLE);
                }
            }
        });

        return root;
    }

    protected void prev(View view){
        Navigation.findNavController(view).navigate(R.id.action_q2_to_q1);
    }

    protected void next(View view) {
        Navigation.findNavController(view).navigate(R.id.action_q2_to_q3);
    }
}