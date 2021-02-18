package com.blandinf.exampledmii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.blandinf.exampledmii.databinding.ActivityMainBinding;

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
    }

    private void redirectTo (Class customClass) {
        Intent intent = new Intent(this, customClass);
        startActivity(intent);
    }
}