package com.example.resume;   // change if your package name is different

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView projectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ListView
        projectList = findViewById(R.id.projectList);

        // Project data
        String[] projects = {
                "Healthcare Management App",
                "Blood & Organ Donation System",
                "Online Resume Builder",
                "Placement Preparation App"
        };

        // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                projects
        );

        // Set adapter to ListView
        projectList.setAdapter(adapter);
    }
}
