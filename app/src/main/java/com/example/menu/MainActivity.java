package com.example.menu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Context Menu Registration
        TextView textView = findViewById(R.id.textView);
        registerForContextMenu(textView);

        // 2. Popup Menu setup
        Button popupButton = findViewById(R.id.popupButton);
        popupButton.setOnClickListener(v -> showPopupMenu(v));
    }

    // --- Options Menu ---
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return handleMenuClick(item.getItemId(), "Options Menu");
    }

    // --- Context Menu ---
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.setHeaderTitle("Select Action");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return handleMenuClick(item.getItemId(), "Context Menu");
    }

    // --- Popup Menu ---
    private void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.getMenuInflater().inflate(R.menu.main_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> handleMenuClick(item.getItemId(), "Popup Menu"));
        popup.show();
    }

    // Helper method to handle clicks and show Toast
    private boolean handleMenuClick(int itemId, String menuType) {
        String itemName = "";
        if (itemId == R.id.item1) itemName = "Item 1";
        else if (itemId == R.id.item2) itemName = "Item 2";
        else if (itemId == R.id.item3) itemName = "Item 3";
        else return false;

        Toast.makeText(this, menuType + ": " + itemName + " selected", Toast.LENGTH_SHORT).show();
        return true;
    }
}