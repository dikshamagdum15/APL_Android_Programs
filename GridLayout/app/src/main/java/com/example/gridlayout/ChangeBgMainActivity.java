package com.example.gridlayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ChangeBgMainActivity extends AppCompatActivity {

    ImageView bgImage;
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_bg);

        bgImage = findViewById(R.id.bgImage);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(v -> bgImage.setImageResource(R.drawable.img));
        btn2.setOnClickListener(v -> bgImage.setImageResource(R.drawable.img_1));
        btn3.setOnClickListener(v -> bgImage.setImageResource(R.drawable.img_2));
    }
}