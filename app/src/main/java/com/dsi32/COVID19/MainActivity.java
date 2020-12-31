package com.dsi32.COVID19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.firebase.auth.FirebaseAuth;



public class MainActivity extends AppCompatActivity{
    TextView TV1;
    TextView TV2;
    TextView TV3;
    TextView TV4;
    TextView TexteV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        TexteV = findViewById(R.id.act1);

        TexteV.setOnClickListener(v -> {
            Intent inte = new Intent(MainActivity.this,MainActivityConnexion.class);
            startActivity(inte);
        });

        TV1 = findViewById(R.id.act4);
        TV1.setOnClickListener(v -> {
            Intent in = new Intent(MainActivity.this,MainActivityContact.class);
            startActivity(in);
        });
        TV2 = findViewById(R.id.act2);
        TV2.setOnClickListener(v -> {
            Intent inte = new Intent(MainActivity.this,MainActivityNotification.class);
            startActivity(inte);
        });
        TV3 = findViewById(R.id.act3);
        TV3.setOnClickListener(v -> {
            Intent inte = new Intent(MainActivity.this,MainActivityInformation.class);
            startActivity(inte);
        });
        TV4 = findViewById(R.id.act5);
        TV4.setOnClickListener(v -> {
            Intent inte = new Intent(MainActivity.this,MainActivityListeContact.class);
            startActivity(inte);
        });

        findViewById(R.id.log_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disconnect();
            }
        });

    }

    private void signOut() {

        FirebaseAuth.getInstance().signOut();

    }

    public void disconnect() {
        signOut();
        finish();
    }


}


