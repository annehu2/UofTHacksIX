package com.example.checked;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Home extends Fragment {

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

        ImageView maskCheckButton = root.findViewById(R.id.mask_check);
        maskCheckButton.setOnClickListener(this::goToMaskCheck);
        ImageView generateQrButton = root.findViewById(R.id.generateQrButton);
        generateQrButton.setOnClickListener(this::goToGenerateCode);
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
}