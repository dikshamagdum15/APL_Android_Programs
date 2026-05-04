package com.example.gridlayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnBgImage, btnBgColor, btnSpinner, btnProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBgImage = findViewById(R.id.btnBgImage);
        btnBgColor = findViewById(R.id.btnBgColor);
        btnSpinner = findViewById(R.id.btnSpinner);
        btnProgress = findViewById(R.id.btnProgress);

        btnBgImage.setOnClickListener(v -> startViewCodeActivity("Change BG Image"));
        btnBgColor.setOnClickListener(v -> startViewCodeActivity("Change BG Color"));
        btnSpinner.setOnClickListener(v -> startViewCodeActivity("Spinner"));
        btnProgress.setOnClickListener(v -> startViewCodeActivity("Progress Bar"));
    }

    private void startViewCodeActivity(String programType) {
        Intent intent = new Intent(MainActivity.this, ViewCodeActivity.class);
        intent.putExtra("PROGRAM_TYPE", programType);
        startActivity(intent);
    }
}
