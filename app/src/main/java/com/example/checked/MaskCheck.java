package com.example.checked;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MaskCheck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mask_check);
        getSupportActionBar().hide();
    }

    public void openCamera(View view) {
        Toast.makeText(this, "Opened Camera!", Toast.LENGTH_SHORT).show(); // Delete this line once shit is done
    }
}