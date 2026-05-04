package com.example.sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etMarks, etId;
    Button btnInsert, btnView, btnUpdate, btnDelete;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etMarks = findViewById(R.id.etMarks);
        etId = findViewById(R.id.etId);

        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        db = new DBHelper(this);

        // INSERT
        btnInsert.setOnClickListener(v -> {
            String name = etName.getText().toString();
            int marks = Integer.parseInt(etMarks.getText().toString());

            boolean result = db.insertData(name, marks);
            Toast.makeText(this, result ? "Inserted" : "Failed", Toast.LENGTH_SHORT).show();
        });

        // VIEW
        btnView.setOnClickListener(v -> {
            Cursor cursor = db.getData();

            if (cursor.getCount() == 0) {
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuilder data = new StringBuilder();
            while (cursor.moveToNext()) {
                data.append("ID: ").append(cursor.getInt(0)).append("\n");
                data.append("Name: ").append(cursor.getString(1)).append("\n");
                data.append("Marks: ").append(cursor.getInt(2)).append("\n\n");
            }

            Toast.makeText(this, data.toString(), Toast.LENGTH_LONG).show();
        });

        // UPDATE
        btnUpdate.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());
            String name = etName.getText().toString();
            int marks = Integer.parseInt(etMarks.getText().toString());

            boolean result = db.updateData(id, name, marks);
            Toast.makeText(this, result ? "Updated" : "Failed", Toast.LENGTH_SHORT).show();
        });

        // DELETE
        btnDelete.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());

            boolean result = db.deleteData(id);
            Toast.makeText(this, result ? "Deleted" : "Failed", Toast.LENGTH_SHORT).show();
        });
    }
}