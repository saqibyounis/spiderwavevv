package com.example.spiderwave.activities;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spiderwave.model.LogasticModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Loagastics extends AppCompatActivity {
    EditText sc,time,pickaddress,dropaddress,contact;
    FirebaseAuth auth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loagastics);
        progressDialog=new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Uploading Info.");


        sc=findViewById(R.id.sc);
       time=findViewById(R.id.time);
       pickaddress=findViewById(R.id.paddress);
       dropaddress=findViewById(R.id.daddress);
       contact=findViewById(R.id.phone);
                auth=FirebaseAuth.getInstance();


    }

    public void submit(View view){
        progressDialog.show();

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference(auth.getCurrentUser().getUid());

        ref.child("Logastics").setValue(new LogasticModel(dropaddress.getText().toString(),pickaddress.getText().toString(),contact.getText().toString(),time.getText().toString(),sc.getText().toString())).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(Loagastics.this, "Complete!", Toast.LENGTH_SHORT).show();
                 progressDialog.dismiss();
                 onBackPressed();


            }
        });



    }

}
