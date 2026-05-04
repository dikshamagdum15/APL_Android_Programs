package com.example.threading;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(v -> {

            // Create Background Thread
            new Thread(() -> {

                for (int i = 1; i <= 5; i++) {

                    try {
                        Thread.sleep(1000); // Simulate long task
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int finalI = i;

                    // Update UI using Handler (Main Thread)
                    new Handler(Looper.getMainLooper()).post(() -> {
                        tvResult.setText("Count: " + finalI);
                    });
                }

            }).start();
        });
    }
}