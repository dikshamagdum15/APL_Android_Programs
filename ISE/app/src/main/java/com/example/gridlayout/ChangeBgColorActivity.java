package com.example.gridlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class ChangeBgColorActivity extends AppCompatActivity {

    Button btnRed, btnGreen, btnBlue, btnBack;
    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_bg_color);

        mainLayout = findViewById(R.id.mainLayout);
        btnRed = findViewById(R.id.btnRed);
        btnGreen = findViewById(R.id.btnGreen);
        btnBlue = findViewById(R.id.btnBlue);
        btnBack = findViewById(R.id.btnBack);

        btnRed.setOnClickListener(v -> mainLayout.setBackgroundColor(Color.RED));
        btnGreen.setOnClickListener(v -> mainLayout.setBackgroundColor(Color.GREEN));
        btnBlue.setOnClickListener(v -> mainLayout.setBackgroundColor(Color.BLUE));

        btnBack.setOnClickListener(v -> finish());
    }
}
