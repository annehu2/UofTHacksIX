package com.example.checked;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Login extends Fragment {
    SharedPreferences sharedPreferences;

    public Login() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getContext().getSharedPreferences("checked", Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_login, container, false);

        ImageView signIn = root.findViewById(R.id.upload_button);
        signIn.setOnClickListener(this::signIn);

        return root;
    }

    public void signIn(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", "fuck_you");
        editor.apply();
        Navigation.findNavController(view).navigate(R.id.action_login_to_home2);
    }
}