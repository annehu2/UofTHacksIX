package com.example.checked;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
//        sharedPreferences = getApplicationContext().getSharedPreferences("checked", Context.MODE_PRIVATE);
//        if (sharedPreferences.getString("token", null) != null) {
//            Fragment frag = getSupportFragmentManager().findFragmentById(R.id.fragmentNav);
//            NavController navController = NavHostFragment.findNavController(frag);
//            navController.navigate(R.id.home2);
//        } else {
//            Fragment frag = getSupportFragmentManager().findFragmentById(R.id.fragmentNav);
//            NavController navController = NavHostFragment.findNavController(frag);
//            navController.navigate(R.id.login);
//        }
        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.fragmentNav);
        NavController navController = NavHostFragment.findNavController(frag);
        navController.navigate(R.id.login);
    }

}