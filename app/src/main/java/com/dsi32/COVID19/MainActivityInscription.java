package com.dsi32.COVID19;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityInscription extends AppCompatActivity {
    EditText emailView;
    EditText passwordView;
    View butoonView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        emailView = findViewById(R.id.mal);
        passwordView = findViewById(R.id.pswd);

        mAuth = FirebaseAuth.getInstance();






     findViewById(R.id.act).setOnClickListener(v -> {
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        if (!isValidEmail(email)) {
            Toast.makeText(MainActivityInscription.this, "Email not valid", Toast.LENGTH_SHORT).show();
        } else if (password.length() < 8) {
            Toast.makeText(MainActivityInscription.this, "MotPass too short", Toast.LENGTH_SHORT).show();
        }else {
            addUser(email, password);
        }
    });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    //method add user dans la base
    public void addUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String TAG = "addclient";
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            //FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                            goToMain();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivityInscription.this, "failed to add", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    private void goToMain() {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}



