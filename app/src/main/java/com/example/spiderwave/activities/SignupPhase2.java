package com.example.spiderwave.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spiderwave.activities.constatns.Constants;
import com.example.spiderwave.model.RewardsModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import spencerstudios.com.bungeelib.Bungee;


public class SignupPhase2 extends AppCompatActivity {
    EditText ph,email,pw,captcha;
    TextView textView;
    FirebaseAuth mAuth;
    private FirebaseFirestore mfirestore;

    public boolean phonesignup=false;
    public boolean emailsignup=false;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth=FirebaseAuth.getInstance();
        mfirestore = FirebaseFirestore.getInstance();
        progressDialog=new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Uploading Info.");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_phase2);
        ph=findViewById(R.id.ph);
        email=findViewById(R.id.email);
        pw=findViewById(R.id.pw1);
        captcha=findViewById(R.id.captcha);
        textView=findViewById(R.id.textView);
        if(Constants.phonenumberSignup){
            ph.setVisibility(View.VISIBLE);
            email.setVisibility(View.GONE);
            textView.setText("Sign Up by Phone Number");
            Constants.phonenumberSignup=false;
            phonesignup=true;

        }else{
            textView.setText("Sign Up by Email");
         email.setVisibility(View.VISIBLE);
            ph.setVisibility(View.GONE);
            Constants.emailSignup=false;
            emailsignup=true;
        }


    }
    public void signup(View view){

        if(captcha.getText().toString().equalsIgnoreCase("8")) {

            if (!(pw.getText().toString().length() > 6)) {
                Toast.makeText(this, "Password Length must be greater than 6.", Toast.LENGTH_SHORT).show();

            } else {
                if(this.phonesignup){
                    Intent intent=new Intent(this,OTPActivity.class);
                    intent.putExtra("pw",pw.getText().toString());
                    intent.putExtra("phonenumber",ph.getText().toString());
                    startActivity(intent);
                    Bungee.shrink(this);



                }else{
                    progressDialog.show();

                    mAuth.createUserWithEmailAndPassword(email.getText().toString(),pw.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      FirebaseDatabase database=FirebaseDatabase.getInstance();
                      DatabaseReference ref=database.getReference(mAuth.getCurrentUser().getUid());

                 ref.child("Rewards").setValue(new RewardsModel(0,"ACR-3478"));
                      progressDialog.dismiss();
                         startActivity(new Intent(SignupPhase2.this,HomeActivity.class));


                  }
              });

                }

            }
            Toast.makeText(this, "Captcha is right.", Toast.LENGTH_SHORT).show();

        }



    }


}
