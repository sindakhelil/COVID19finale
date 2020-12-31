package com.dsi32.COVID19;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityTraitement extends AppCompatActivity {
ImageView IM1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traitement);
        IM1 = findViewById(R.id.back);
        IM1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityTraitement.this,MainActivityInformation.class);
            startActivity(intent);
        });
    }
}