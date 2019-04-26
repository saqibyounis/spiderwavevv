package com.example.spiderwave.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth=FirebaseAuth.getInstance();


    }
    public void submitITR(View view){
     startActivity(new Intent(this,SubmitITR.class));


    }

    public void loan(View view){
        startActivity(new Intent(this,LoanActivity.class));


    }
    public void logastics(View view){
        startActivity(new Intent(this,Loagastics.class));


    }
    public void checkRewards(View view){
        startActivity(new Intent(this,CheckRewards.class));


    }

    public void logout(View view){
        mAuth.signOut();
        onBackPressed();

    }


}
