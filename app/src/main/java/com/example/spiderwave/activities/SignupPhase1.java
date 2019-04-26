package com.example.spiderwave.activities;

import android.app.usage.ConfigurationStats;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.spiderwave.activities.constatns.Constants;

import spencerstudios.com.bungeelib.Bungee;

public class SignupPhase1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_phase1);



    }
    public void emailSignup(View view){

        Constants.emailSignup=true;
        startActivity(new Intent(this,SignupPhase2.class));
        Bungee.inAndOut(this);

    }

    public void phonenumberSignup(View view){
        Constants.phonenumberSignup=true;
        startActivity(new Intent(this,SignupPhase2.class));
        Bungee.inAndOut(this);

    }

}
