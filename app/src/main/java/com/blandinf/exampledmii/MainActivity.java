package com.blandinf.exampledmii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.blandinf.exampledmii.databinding.ActivityMainBinding;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == binding.redirectSecondViewButton) {
                redirectTo(SecondActivity.class);
            } else if (v == binding.sendEmailButton) {
                redirectTo(MailActivity.class);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.sendEmailButton.setOnClickListener(listener);
        binding.redirectSecondViewButton.setOnClickListener(listener);
        Glide.with(this).load("https://www.numerama.com/content/uploads/2020/01/mercure-planete-espace-1.jpg").into(binding.myImage);
    }

    private void redirectTo (Class customClass) {
        Intent intent = new Intent(this, customClass);
        startActivity(intent);
    }
}