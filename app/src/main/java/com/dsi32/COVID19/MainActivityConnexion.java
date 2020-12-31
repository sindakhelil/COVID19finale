package com.dsi32.COVID19;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivityConnexion extends AppCompatActivity {

    private FirebaseAuth mAuth;
    TextView Texte;
    private SharedPreferences Preferences;
    private SharedPreferences.Editor editor;
    private CheckBox checkboxcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        Texte = findViewById(R.id.sous);
        Texte.setOnClickListener(v -> {
            Intent inte = new Intent(MainActivityConnexion.this,MainActivityInscription.class);
            startActivity(inte);
        });
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.id2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText loginView = findViewById(R.id.mal);
                EditText motPassView = findViewById(R.id.pswd);

                String login = loginView.getText().toString();
                String password = motPassView.getText().toString();
                //
                if (login.length() > 6 && password.length() > 8) {

                    //Toast.makeText(Login.this, login+" "+password, Toast.LENGTH_LONG).show();
                    login(login, password);
                } else {
                    Toast.makeText(MainActivityConnexion.this, "Enter a valid login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
        @Override
        public void onStart() {
            super.onStart();
            // Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = mAuth.getCurrentUser();
            //updateUI(currentUser);

            if (currentUser != null) {
                goToMain();
                Toast.makeText(this, "Welcome Back! ", Toast.LENGTH_SHORT).show();
            }
        }

        public void login(String email, String password) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            String TAG = "singin";
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                //Toast.makeText(Login.this, "ok", Toast.LENGTH_SHORT).show();
                                //updateUI(user);
                                goToMain();
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(MainActivityConnexion.this, "Authentication failed.",
                                        Toast.LENGTH_LONG).show();
                                //updateUI(null);
                            }

                            // ...
                        }
                    });
        }
    private void goToMain() {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }




    }
