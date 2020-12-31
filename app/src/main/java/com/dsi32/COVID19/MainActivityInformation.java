package com.dsi32.COVID19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class
MainActivityInformation extends AppCompatActivity {
    TextView TV;
    TextView TV1;
    TextView TV2;
    ImageView IM1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations);
        TV = findViewById(R.id.texte1);
        TV.setOnClickListener(v -> {
            Intent inte = new Intent(MainActivityInformation.this,MainActivitySymptomes.class);
            startActivity(inte);
        });
        TV1 = findViewById(R.id.texte2);
        TV1.setOnClickListener(v -> {
            Intent inte = new Intent(MainActivityInformation.this,MainActivityPrevention.class);
            startActivity(inte);
        });
        TV2 = findViewById(R.id.texte3);
        TV2.setOnClickListener(v -> {
            Intent inte = new Intent(MainActivityInformation.this,MainActivityTraitement.class);
            startActivity(inte);
        });
        IM1 = findViewById(R.id.fleche);
        IM1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityInformation.this,MainActivity.class);
            startActivity(intent);
        });
    }
}