package com.example.registrationform;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, email;
    RadioGroup genderGroup;
    CheckBox cbMusic, cbSports, cbReading;
    ToggleButton toggleAgree;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);

        genderGroup = findViewById(R.id.genderGroup);

        cbMusic = findViewById(R.id.cbMusic);
        cbSports = findViewById(R.id.cbSports);
        cbReading = findViewById(R.id.cbReading);

        toggleAgree = findViewById(R.id.toggleAgree);

        submit = findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = name.getText().toString();
                String userEmail = email.getText().toString();

                int selectedId = genderGroup.getCheckedRadioButtonId();
                RadioButton gender = findViewById(selectedId);

                String hobbies = "";

                if(cbMusic.isChecked())
                    hobbies += "Music ";

                if(cbSports.isChecked())
                    hobbies += "Sports ";

                if(cbReading.isChecked())
                    hobbies += "Reading ";

                String agree = toggleAgree.isChecked() ? "Agreed" : "Not Agreed";

                String result = "Name: " + userName +
                        "\nEmail: " + userEmail +
                        "\nGender: " + gender.getText() +
                        "\nHobbies: " + hobbies +
                        "\nTerms: " + agree;

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }
}