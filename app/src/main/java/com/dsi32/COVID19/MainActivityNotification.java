package com.dsi32.COVID19;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.ref.Reference;
import java.util.List;

public class MainActivityNotification extends AppCompatActivity {
    ImageView IM1;
    List<Contact> contacts;
    DatabaseReference databaseArtists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        IM1 = findViewById(R.id.imag);
        String mails;
        databaseArtists = FirebaseDatabase.getInstance().getReference("contacts");
        IM1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityNotification.this,MainActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.appel).setOnClickListener(this::sendEmail);
    }
    public void sendEmail(View v){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mailto:"));
        String to="";
        i.putExtra(Intent.EXTRA_EMAIL,to);
        i.putExtra(Intent.EXTRA_SUBJECT,"Covid19");
        i.putExtra(Intent.EXTRA_TEXT,"malheureusement,Je vous informe que j'ai testé positive,merci de faire un testcovid19 ");
        i.setType("message/rfc822");
        Intent choose = Intent.createChooser(i,"send Email");
        startActivity(choose);
        Toast.makeText(MainActivityNotification.this,"Email envoyée", Toast.LENGTH_LONG).show();
}
}