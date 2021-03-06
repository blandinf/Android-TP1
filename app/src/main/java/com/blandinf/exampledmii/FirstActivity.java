package com.blandinf.exampledmii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.blandinf.exampledmii.databinding.ActivityFirstBinding;

public class FirstActivity extends AppCompatActivity {

    Integer count = 0;
    ActivityFirstBinding binding;

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == binding.incrementButton) {
                increment();
            } else if (v == binding.toastButton) {
                toast();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init () {
        binding.incrementButton.setOnClickListener(listener);
        binding.toastButton.setOnClickListener(listener);

        binding.countTextView.setText(count.toString());
    }

    private void increment () {
        count++;
        binding.countTextView.setText(count.toString());
    }

    private void toast () {
        Toast.makeText(FirstActivity.this, count.toString(), Toast.LENGTH_SHORT).show();
    }
}