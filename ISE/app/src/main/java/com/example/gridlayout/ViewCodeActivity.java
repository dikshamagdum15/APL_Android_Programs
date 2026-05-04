package com.example.gridlayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ViewCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_code);

        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvCode = findViewById(R.id.tvCode);
        Button btnBackCode = findViewById(R.id.btnBackCode);

        String programType = getIntent().getStringExtra("PROGRAM_TYPE");
        String fileName = "";

        if (programType != null) {
            tvTitle.setText(programType + " Code");
            switch (programType) {
                case "Change BG Image": fileName = "ChangeBgMainActivity.java"; break;
                case "Change BG Color": fileName = "ChangeBgColorActivity.java"; break;
                case "Spinner": fileName = "SpinnerActivity.java"; break;
                case "Progress Bar": fileName = "ProgressBarActivity.java"; break;
            }
            
            tvCode.setText(readCodeFromAssets(fileName));
        }

        btnBackCode.setOnClickListener(v -> finish());
    }

    private String readCodeFromAssets(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream is = getAssets().open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            is.close();
        } catch (Exception e) {
            return "Error loading file: " + e.getMessage();
        }
        return stringBuilder.toString();
    }
}
