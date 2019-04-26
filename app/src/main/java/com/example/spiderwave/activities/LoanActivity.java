package com.example.spiderwave.activities;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spiderwave.model.LoanModel;
import com.example.spiderwave.model.LogasticModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoanActivity extends AppCompatActivity {
    EditText bank,loanamount,tenure,emi;
    FirebaseAuth auth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);
        progressDialog=new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Uploading Info.");


        bank=findViewById(R.id.bank);
        loanamount=findViewById(R.id.lamount);
        tenure=findViewById(R.id.tenure);
        emi=findViewById(R.id.emiamount);
        auth=FirebaseAuth.getInstance();

    }
    public void submit(View view){
         progressDialog.show();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference(auth.getCurrentUser().getUid());

        ref.child("Loan").setValue(new LoanModel(loanamount.getText().toString(),emi.getText().toString(),bank.getText().toString(),tenure.getText().toString())).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(LoanActivity.this, "Complete !", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                onBackPressed();
            }
        });



    }


}
