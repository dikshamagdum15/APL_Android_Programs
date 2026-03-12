package com.example.gridlayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnBgImage, btnBgColor, btnSpinner,
            btnProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBgImage = findViewById(R.id.btnBgImage);
        btnBgColor = findViewById(R.id.btnBgColor);
        btnSpinner = findViewById(R.id.btnSpinner);
        btnProgress = findViewById(R.id.btnProgress);

        btnBgImage.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ChangeBgMainActivity.class)));

        btnBgColor.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ChangeBgColorActivity.class)));

        btnSpinner.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, SpinnerActivity.class)));

        btnProgress.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ProgressBarActivity.class)));
}
}