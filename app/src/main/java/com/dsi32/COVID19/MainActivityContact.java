package com.dsi32.COVID19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityContact extends AppCompatActivity {
    ImageView IM;
    Button annuler;
    Button enrigistrer;
    EditText userName;
    EditText userAdress;
    EditText userMail;
    EditText numbOfTimes ;
    DatePicker contactDate;

    //our database reference object
    DatabaseReference databaseArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        //getting the reference of artists node
        databaseArtists = FirebaseDatabase.getInstance().getReference("contacts");
        IM = findViewById(R.id.img);
        enrigistrer = findViewById(R.id.btn1);
        userName = findViewById(R.id.userName);
        userAdress = findViewById(R.id.adress);
        userMail = findViewById(R.id.adressMail);
        numbOfTimes = findViewById(R.id.numbOfTimes);
        contactDate = findViewById(R.id.datePicker1);

        IM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityContact.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //adding an onclicklistener to button
        enrigistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addContact();
            }
        });

    }
    /*
     * This method is saving a new contact to the
     * Firebase Realtime Database
     * */
    private void addContact() {
        //getting the values to save
        String name = userName.getText().toString().trim();
        String adress = userAdress.getText().toString().trim();
        String mail = userMail.getText().toString().trim();
        String numb = numbOfTimes.getText().toString().trim();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(adress)  && !TextUtils.isEmpty(mail)  &&
                !TextUtils.isEmpty(numb)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseArtists.push().getKey();

            //creating an Artist Object
            Contact contact = new Contact(id, name, adress,mail,numb);

            //Saving the Artist
            databaseArtists.child(id).setValue(contact);

            //setting all  to blank again
            userName.setText("");
            userAdress.setText("");
            userMail.setText("");
            numbOfTimes.setText("");

            //displaying a success toast
            Toast.makeText(this, "Contact added", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(name)) {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(adress)) {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter an adress", Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(mail)) {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter an email", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Please enter the number of times ", Toast.LENGTH_LONG).show();
        }
    }
}