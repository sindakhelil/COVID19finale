package com.dsi32.COVID19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivityListeContact extends AppCompatActivity {
    ImageView IM;
    //a list to store all the artist from firebase database
    List<Contact> contacts;
    //our database reference object
    DatabaseReference databaseArtists;
    ListView listViewContacts ;
    TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listecontact);
        contacts = new ArrayList<>();
        //getting the reference of contacts node
        databaseArtists = FirebaseDatabase.getInstance().getReference("contacts");
        IM = findViewById(R.id.back3);
        tableLayout=(TableLayout)findViewById(R.id.tableLayout);
        IM.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityListeContact.this,MainActivity.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                contacts.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting contacts
                    Contact contact = postSnapshot.getValue(Contact.class);
                    //adding contacts to the list
                    contacts.add(contact);
                }
                for (int i=0;i<contacts.size();i++){
                    View tableRow = LayoutInflater.from(MainActivityListeContact.this).inflate(R.layout.table_contacts,null,false);
                    TextView name  = (TextView) tableRow.findViewById(R.id.Nom);
                    TextView adresse  = (TextView) tableRow.findViewById(R.id.Adresse);
                    TextView email = (TextView) tableRow.findViewById(R.id.Email);
                    TextView number = (TextView) tableRow.findViewById(R.id.Nombre);

                    name.setText(contacts.get(i).getContactName());
                    adresse.setText(contacts.get(i).getContactAdress());
                    email.setText(contacts.get(i).getContactMail());
                    number.setText(contacts.get(i).getNumberOfTimes());
                    tableLayout.addView(tableRow);
                }
                //creating adapter
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}