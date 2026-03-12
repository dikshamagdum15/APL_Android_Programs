package com.example.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editName);
        send = findViewById(R.id.btnSend);

        send.setOnClickListener(v -> {

            String username = name.getText().toString();

            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("name", username);

            startActivity(i);
        });
    }
}