package com.example.spiderwave.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import spencerstudios.com.bungeelib.Bungee;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    EditText email;
    EditText pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_main);
          email=findViewById(R.id.email);
          pw=findViewById(R.id.pw);


    }

    public void signup(View view){

        startActivity(new Intent(MainActivity.this,SignupPhase1.class));
        Bungee.diagonal(MainActivity.this);
    }
    public void login(View view){

        mAuth.signInWithEmailAndPassword(email.getText().toString(),pw.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

              if(task.isSuccessful())  startActivity(new Intent(MainActivity.this,HomeActivity.class));
             else         Toast.makeText(MainActivity.this, "Login Fail!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=mAuth.getCurrentUser();
        if(user!=null) {
            startActivity(new Intent(this, HomeActivity.class));
            Bungee.shrink(this);

        }

    }

    public void loginByPhonenumber(View view){

        startActivity(new Intent(this,LoginByPhonenumber.class));

    }


}
