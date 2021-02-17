package com.blandinf.exampledmii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button incrementBtn;
    Button toastBtn;
    TextView countTextView;
    Integer count = 0;

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == incrementBtn) {
                increment();
            } else if (v == toastBtn) {
                toast();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init () {
        incrementBtn = (Button) findViewById(R.id.incrementBtn);
        toastBtn = (Button) findViewById(R.id.toastBtn);
        countTextView = (TextView) findViewById(R.id.countTextView);

        incrementBtn.setOnClickListener(listener);
        toastBtn.setOnClickListener(listener);

        countTextView.setText(count.toString());
    }

    private void increment () {
        count++;
        countTextView.setText(count.toString());
    }

    private void toast () {
        Toast.makeText(MainActivity.this, count.toString(), Toast.LENGTH_SHORT).show();
    }
}