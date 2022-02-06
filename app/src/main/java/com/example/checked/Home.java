package com.example.checked;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Home extends Fragment {
    SharedPreferences sharedPreferences;
    public Home() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        sharedPreferences = getActivity().getSharedPreferences("checked", Context.MODE_PRIVATE);

        ImageView maskCheckButton = root.findViewById(R.id.mask_check);
        maskCheckButton.setOnClickListener(this::goToMaskCheck);

        ImageView generateQrButton = root.findViewById(R.id.generateQrButton);
        generateQrButton.setOnClickListener(this::goToGenerateCode);


        ImageView covidScreeningButton = root.findViewById(R.id.covid_screening);
        covidScreeningButton.setOnClickListener(this::covidScreening);
        ImageView start = root.findViewById(R.id.start_text);

        ImageView step1 = root.findViewById(R.id.step1);
        ImageView step2 = root.findViewById(R.id.step2);
        ImageView step3 = root.findViewById(R.id.step3);

        ImageView qrcode = root.findViewById(R.id.generateQrButton);

        if(sharedPreferences.getBoolean("screening", false)){
            step1.setVisibility(View.INVISIBLE);
            step2.setVisibility(View.VISIBLE);
            covidScreeningButton.setImageResource(R.drawable.done_screening);
            start.setImageResource(R.drawable.start_mask);
        }
        if(sharedPreferences.getBoolean("maskcheck", false)){
            step1.setVisibility(View.INVISIBLE);
            step2.setVisibility(View.INVISIBLE);
            step3.setVisibility(View.VISIBLE);
            covidScreeningButton.setVisibility(View.INVISIBLE);
            maskCheckButton.setVisibility(View.INVISIBLE);
            generateQrButton.setVisibility(View.VISIBLE);
            start.setImageResource(R.drawable.start_qr);
        }

        return root;
    }

    public void goToMaskCheck(View view) {
        Intent maskCheck = new Intent(getContext(), MaskCheck.class);
        startActivity(maskCheck);
    }

    public void goToGenerateCode(View view) {
        Intent qrCode = new Intent(getContext(), GenerateCode.class);
        startActivity(qrCode);
    }

    public void covidScreening(View view) {
        Intent screening = new Intent(getContext(), Screening.class);
        startActivity(screening);
    }
}