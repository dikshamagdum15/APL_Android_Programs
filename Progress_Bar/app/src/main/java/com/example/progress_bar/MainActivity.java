package com.example.progress_bar;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    ProgressBar progressBar;
    Button btnStart;

    int progressStatus = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        progressBar = findViewById(R.id.progressBar);
        btnStart = findViewById(R.id.btnStart);

        // ✅ RatingBar Event
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            Toast.makeText(MainActivity.this,
                    "Rating: " + rating,
                    Toast.LENGTH_SHORT).show();
        });

        // ✅ ProgressBar Event
        btnStart.setOnClickListener(v -> {

            progressStatus = 0;
            progressBar.setProgress(0);

            new Thread(() -> {
                while (progressStatus < 100) {
                    progressStatus += 5;

                    handler.post(() -> progressBar.setProgress(progressStatus));

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                handler.post(() ->
                        Toast.makeText(MainActivity.this,
                                "Download Completed!",
                                Toast.LENGTH_SHORT).show());
            }).start();
        });
    }
}