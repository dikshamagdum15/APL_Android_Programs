package com.example.loginresume;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResumeActivity extends AppCompatActivity {

    TextView nameText, emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);

        String email = getIntent().getStringExtra("email");

        // Extract name from email
        String name = email.substring(0, email.indexOf("@"));

        nameText.setText("Name: " + name);
        emailText.setText("Email: " + email);
    }
}