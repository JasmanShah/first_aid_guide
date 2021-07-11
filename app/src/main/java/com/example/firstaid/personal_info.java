package com.example.firstaid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class personal_info extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info_layout);
        Button deleteButton = findViewById(R.id.deleteInfo);
        Button updateButton = findViewById(R.id.updateInfo);
        Button insertButton = findViewById(R.id.insertInfo);
        deleteButton.setVisibility(View.INVISIBLE);
        updateButton.setVisibility(View.INVISIBLE);
    }
}
