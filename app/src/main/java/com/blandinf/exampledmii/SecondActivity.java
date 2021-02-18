package com.blandinf.exampledmii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.blandinf.exampledmii.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.firstNumber != null && binding.secondNumber != null) {
                    Double result = Double.parseDouble(binding.firstNumber.getText().toString()) + Double.parseDouble(binding.secondNumber.getText().toString());
                    binding.result.setText(result.toString());
                }
            }
        });
    }
}