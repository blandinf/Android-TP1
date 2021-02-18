package com.blandinf.exampledmii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.blandinf.exampledmii.databinding.ActivityMailBinding;

public class MailActivity extends AppCompatActivity {

    ActivityMailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.sendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail () {
        Intent sendEmailIntent = new Intent(Intent.ACTION_SENDTO);
        String mailto = "mailto:" + binding.email.getText().toString() +
                "?cc=" + binding.cc.getText().toString() +
                "&subject=" + Uri.encode(binding.subject.getText().toString()) +
                "&body=" + Uri.encode(binding.body.getText().toString());
        sendEmailIntent.setData(Uri.parse(mailto));
        if (sendEmailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendEmailIntent);
        }
    }
}