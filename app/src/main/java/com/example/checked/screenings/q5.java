package com.example.checked.screenings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.checked.MainActivity;
import com.example.checked.R;
public class q5 extends Fragment {
    SharedPreferences sharedPreferences;

    public q5() {
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
        View root = inflater.inflate(R.layout.fragment_q5, container, false);

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

        sharedPreferences = getActivity().getSharedPreferences("checked", Context.MODE_PRIVATE);

        return root;
    }

    protected void prev(View view) {
        Navigation.findNavController(view).navigate(R.id.action_q5_to_q4);
    }

    protected void next(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("screening", true);
        editor.putString("goTo", "Home");
        editor.apply();
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }
}