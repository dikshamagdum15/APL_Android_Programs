package com.example.spinners;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Spinner spinnerCourse;
    Button btnSubmit, btnPopup;

    String[] courses = {"Select Course", "BCA", "BBA", "BTech", "MCA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        spinnerCourse = findViewById(R.id.spinnerCourse);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnPopup = findViewById(R.id.btnPopup);

        // ✅ Spinner Setup
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                courses);

        spinnerCourse.setAdapter(adapter);

        // ✅ Spinner Event
        spinnerCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0){
                    Toast.makeText(MainActivity.this,
                            "Selected: " + courses[position],
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        // ✅ Popup Menu
        btnPopup.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                Toast.makeText(MainActivity.this,
                        item.getTitle() + " clicked",
                        Toast.LENGTH_SHORT).show();
                return true;
            });

            popupMenu.show();
        });

        // ✅ Submit Button → AlertDialog
        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String selectedCourse = spinnerCourse.getSelectedItem().toString();

            if(name.isEmpty()){
                Toast.makeText(MainActivity.this,
                        "Enter your name",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if(selectedCourse.equals("Select Course")){
                Toast.makeText(MainActivity.this,
                        "Select a course",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            // Alert Dialog
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Form Submitted")
                    .setMessage("Name: " + name +
                            "\nCourse: " + selectedCourse)
                    .setPositiveButton("OK", (dialog, which) ->
                            Toast.makeText(MainActivity.this,
                                    "Success!",
                                    Toast.LENGTH_SHORT).show())
                    .setNegativeButton("Cancel", null)
                    .show();
        });
    }
}