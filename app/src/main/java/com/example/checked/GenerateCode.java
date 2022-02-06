package com.example.checked;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GenerateCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_code);

        setVerified(true);

    }

    public void setVerified(boolean isVerified) {
        if (isVerified) {
            ImageView verified = findViewById(R.id.qrCodeVerified);
            verified.setVisibility(View.VISIBLE);
        } else {
            ImageView notVerified = findViewById(R.id.notVerified);
            notVerified.setVisibility(View.VISIBLE);
        }

    }
}