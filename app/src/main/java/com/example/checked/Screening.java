package com.example.checked;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

public class Screening extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening);
        getSupportActionBar().hide();

        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.fragmentNav2);
        NavController navController = NavHostFragment.findNavController(frag);
        navController.navigate(R.id.q1);
    }
}