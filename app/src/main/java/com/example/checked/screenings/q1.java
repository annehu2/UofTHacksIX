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

public class q1 extends Fragment {

    public q1() {
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
        View root = inflater.inflate(R.layout.fragment_q1, container, false);

        ImageView prev = root.findViewById(R.id.prev);
        ImageView next = root.findViewById(R.id.next);
        RadioButton yes = root.findViewById(R.id.radioButton);
        RadioButton no = root.findViewById(R.id.radioButton2);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setVisibility(View.VISIBLE);
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setVisibility(View.INVISIBLE);
            }
        });
        prev.setOnClickListener(this::prev);
        next.setOnClickListener(this::next);

        return root;
    }

    protected void prev(View view) {
        getActivity().finish();
    }

    protected void next(View view) {
        Navigation.findNavController(view).navigate(R.id.action_q1_to_q2);
    }
}