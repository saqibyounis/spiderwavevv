package com.example.spiderwave.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
/*
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;*/

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SubmitITR extends AppCompatActivity {
    private EditText edtName, edtEmail, edtAddress, edtPhone,bkn,brk,b,fname,gstn,mnumber,contactinfo,paddress,comaddress;
    private ImageView imageViewPAN;
    private ImageView imageViewAadhaar,im1,im2,im3,di1,di2,di3;
    private CheckBox checkBoxGSTIN;
    private TextView tvUserID;
    private Button btnSignUp;
    private TextView textViewPAN;
    private TextView textViewAadhaar;
    private RadioGroup radioGroupUserID,gender,rentg;
    private RadioButton radioButtonEmail;
    private RadioButton radioButtonPhone,male,female,rn,ry;
    private EditText edtPassword;
    private FirebaseFirestore mfirestore;
    private StorageReference storageReference;
    private FirebaseAuth auth;

    private static final int PICK_IMAGE_REQUEST_PAN = 234;
    private static final int PICK_IMAGE_REQUEST_AADHAAR = 235;
    private Uri filePath;
    private String download_urlPAN;
    private String download_AADHAAR;

    private String url_im1;
    private String url_im2;
    private String url_im3;
    private String url_di1;

    private String url_di2;

    private String url_di3;

    private String name;
    private String email;
    private String address;
    private String phone;
    private String password;

    private String fathername,parmanentaddress,commaddress,bank,acountnumber,ifsccode,phonenumber,cotactinformation;

    private ProgressDialog progressDialog;
    //private boolean isGSTIN;
    private String userID;
    private Button brnSignIn;
    private EditText edtGSTIN;
    private String GSTIN;

    private static int PICK_IM1=1;

    private static int PICK_IM2=2;
    private static int PICK_IM3=3;
    private static int PICK_DI1=4;
    private static int PICK_DI2=5;
    private static int PICK_DI3=6;
    String gendertext="";
    private String styingrent="";
    private String gstntext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_itr);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtAddress = findViewById(R.id.edtAddress);
       // edtPhone = findViewById(R.id.edtPhone);

        imageViewPAN = findViewById(R.id.imageViewPAN);
        imageViewAadhaar = findViewById(R.id.imageViewAadhaar);
      //  checkBoxGSTIN = findViewById(R.id.checkBoxGSTIN);
           auth=FirebaseAuth.getInstance();
        gstn=findViewById(R.id.gstn);
       // tvUserID = findViewById(R.id.paddress);
        textViewPAN = findViewById(R.id.textViewPAN);
       // textViewAadhaar = findViewById(R.id.textViewAadhaar);
        //btnSignUp = findViewById(R.id.btnSignUp);

        checkBoxGSTIN=findViewById(R.id.checkBoxGSTIN);
    rentg=findViewById(R.id.rentg);
    ry=findViewById(R.id.ry);
    rn=findViewById(R.id.rn);
    gender=findViewById(R.id.gender);
    female=findViewById(R.id.female);
    male=findViewById(R.id.male);
        bkn = findViewById(R.id.bkn);
        b=findViewById(R.id.b);
        brk=findViewById(R.id.brk);
        fname=findViewById(R.id.fname);
        mnumber=findViewById(R.id.mnumber);
        contactinfo=findViewById(R.id.contactinfo);
        comaddress=findViewById(R.id.comaddress);
        paddress=(EditText) findViewById(R.id.praddress);

        im1=findViewById(R.id.im1);
        im2=findViewById(R.id.im2);
        im3=findViewById(R.id.im3);

        di1=findViewById(R.id.di1);
        di2=findViewById(R.id.di2);
        di3=findViewById(R.id.di3);


        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser3(PICK_IM1);

            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser3(PICK_IM2);

            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser3(PICK_IM3);

            }
        });


        di1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser3(PICK_DI1);

            }
        });
        di2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser3(PICK_DI2);

            }
        });
        di3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser3(PICK_DI3);

            }
        });
        rentg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check is there GSTIN if True >>> yes
                if (ry.isChecked()) {
                    //isGSTIN = true;
                    styingrent="yes";
                } else if (!checkBoxGSTIN.isChecked()) {
                    //isGSTIN = false;
                    styingrent="no";
                }
            }
        });

        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check is there GSTIN if True >>> yes
                if (male.isChecked()) {
                    //isGSTIN = true;
                    gendertext="male";
                } else if (!checkBoxGSTIN.isChecked()) {
                    //isGSTIN = false;
gendertext="female";
                }
            }
        });
        GSTIN = null;
        checkBoxGSTIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check is there GSTIN if True >>> yes
                if (checkBoxGSTIN.isChecked()) {
                    //isGSTIN = true;
                    gstn.setVisibility(View.VISIBLE);

                } else if (!checkBoxGSTIN.isChecked()) {
                    //isGSTIN = false;
                    gstn.setVisibility(View.GONE);

                }
            }
        });



        progressDialog = new ProgressDialog(this);
          progressDialog.setCanceledOnTouchOutside(false);
        filePath = null;
        auth = FirebaseAuth.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        mfirestore = FirebaseFirestore.getInstance();





        imageViewPAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser1();

            }
        });

        imageViewAadhaar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser2();

            }
        });
    }

    private void showFileChooser3(int pickDi3) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent, "Select an Image"), pickDi3);



    }

    public void submit(View view){


        name = edtName.getText().toString();
        email = edtEmail.getText().toString();
        address = edtAddress.getText().toString();
        //phone = edtPhone.getText().toString();
//        password = edtPassword.getText().toString();
     //   GSTIN = edtGSTIN.getText().toString();
         phonenumber=mnumber.getText().toString();
        cotactinformation=contactinfo.getText().toString();

        if(gstn.getText().toString().isEmpty()){
        gstntext="not";

        }else {
            gstntext = gstn.getText().toString();
        }
        fathername=fname.getText().toString();
        parmanentaddress=paddress.getText().toString();
        commaddress=comaddress.getText().toString();
        bank=bkn.getText().toString();
        acountnumber=brk.getText().toString();
        phonenumber=mnumber.getText().toString();
        cotactinformation=contactinfo.getText().toString();
        ifsccode=b.getText().toString();


if(name.isEmpty()&&email.isEmpty()&& address.isEmpty()&&  phonenumber.isEmpty()&& cotactinformation.isEmpty()&& fathername.isEmpty()&&parmanentaddress.isEmpty()&& commaddress.isEmpty()&&bank.isEmpty()&&acountnumber.isEmpty()&&ifsccode.isEmpty()){


    Toast.makeText(this, "Some Fields Are Empty! Please Check.", Toast.LENGTH_SHORT).show();
}else{
    if(true){


        FirebaseUser user=auth.getCurrentUser();
        if (filePath != null) {
            final StorageReference riversRefPAN = storageReference.child("Images/Users/PAN/" + edtName.getText().toString() + " " + "PAN" + ".jpg");
            riversRefPAN.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    riversRefPAN.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            download_urlPAN = uri.toString();
//https://www.google.com/search?client=ubuntu&channel=fs&q=fsdf&ie=utf-8&oe=utf-8
                            final StorageReference rim2 = storageReference.child("Images/Users/AADHAAR/" + edtName.getText().toString() + " " + "im2" + ".jpg");

                            final StorageReference rim3 = storageReference.child("Images/Users/AADHAAR/" + edtName.getText().toString() + " " + "im3" + ".jpg");

                            final StorageReference rdi1 = storageReference.child("Images/Users/AADHAAR/" + edtName.getText().toString() + " " + "di1" + ".jpg");

                            final StorageReference rdi2 = storageReference.child("Images/Users/AADHAAR/" + edtName.getText().toString() + " " + "di2" + ".jpg");

                            final StorageReference rdi3 = storageReference.child("Images/Users/AADHAAR/" + edtName.getText().toString() + " " + "di3" + ".jpg");

                            final StorageReference riversRefAADHAAR = storageReference.child("Images/Users/AADHAAR/" + edtName.getText().toString() + " " + "AADHAAR" + ".jpg");
                            riversRefAADHAAR.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    riversRefAADHAAR.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {

                                            download_AADHAAR = uri.toString();

                                            final StorageReference rim1 = storageReference.child("Images/Users/AADHAAR/" + edtName.getText().toString() + " " + "im1" + ".jpg");
                                            rim1.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                @Override
                                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                    rim1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                        @Override
                                                        public void onSuccess(Uri uri) {

                                                            url_im1 = uri.toString();
                                                            final StorageReference rim2 = storageReference.child("Images/Users/AADHAAR/" + edtName.getText().toString() + " " + "im2" + ".jpg");
                                                            rim2.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                                @Override
                                                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                                    rim2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                                        @Override
                                                                        public void onSuccess(Uri uri) {

                                                                            url_im2 = uri.toString();
                                                                            final StorageReference rim3 = storageReference.child("Images/Users/AADHAAR/" + edtName.getText().toString() + " " + "im3" + ".jpg");
                                                                            rim3.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                                                @Override
                                                                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                                                    rim1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                                                        @Override
                                                                                        public void onSuccess(Uri uri) {

                                                                                            url_im3 = uri.toString();
                                                                                            final StorageReference rdi1 = storageReference.child("Images/Users/AADHAAR/" + edtName.getText().toString() + " " + "di1" + ".jpg");
                                                                                            rdi1.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                                                                @Override
                                                                                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                                                                    rdi1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                                                                        @Override
                                                                                                        public void onSuccess(Uri uri) {

                                                                                                            url_di1 = uri.toString();
                                                                                                            final StorageReference rdi2 = storageReference.child("Images/Users/AADHAAR/" + edtName.getText().toString() + " " + "di2" + ".jpg");
                                                                                                            rdi2.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                                                                                @Override
                                                                                                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                                                                                    rim1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                                                                                        @Override
                                                                                                                        public void onSuccess(Uri uri) {

                                                                                                                            url_di2 = uri.toString();

                                                                                                                            final StorageReference rdi3 = storageReference.child("Images/Users/AADHAAR/" + edtName.getText().toString() + " " + "di3" + ".jpg");
                                                                                                                            rdi3.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                                                                                                @Override
                                                                                                                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                                                                                                    rim1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                                                                                                        @Override
                                                                                                                                        public void onSuccess(Uri uri) {

                                                                                                                                            url_di3 = uri.toString();



                                                                                                                                            Map<String, Object> userMap = new HashMap<>();
                                                                                                                                            userMap.put("name", name);
                                                                                                                                            userMap.put("address", address);
                                                                                                                                            //    userMap.put("phone", phone);
                                                                                                                                            userMap.put("email", email);
                                                                                                                                            userMap.put("download_urlPAN", download_urlPAN);
                                                                                                                                            userMap.put("download_AADHAAR", download_AADHAAR);
                                                                                                                                            userMap.put("GSTIN", gstntext);
                                                                                                                                            userMap.put("userID", userID);
                                                                                                                                            userMap.put("authID", auth.getUid());
                                                                                                                                            userMap.put("password", password);
                                                                                                                                            userMap.put("fathername", fathername);
                                                                                                                                            userMap.put("communicationaddress", commaddress);
                                                                                                                                            userMap.put("parmanentaddress", parmanentaddress);
                                                                                                                                            userMap.put("bank", bank);
                                                                                                                                            userMap.put("acountnumber", acountnumber);
                                                                                                                                            userMap.put("ifscode", ifsccode);
                                                                                                                                            userMap.put("gender", gendertext);
                                                                                                                                            userMap.put("styinrent", styingrent);
                                                                                                                                            userMap.put("mobilenumber", phonenumber);
                                                                                                                                            userMap.put("contactinfo", cotactinformation);
                                                                                                                                            userMap.put("urlim1",url_im1);
                                                                                                                                            userMap.put("urlim2",url_im2);

                                                                                                                                            userMap.put("urlim3",url_im3);

                                                                                                                                            userMap.put("urldi1",url_di1);

                                                                                                                                            userMap.put("urldi2",url_di2);
                                                                                                                                            userMap.put("urldi3",url_di3);
                                                                                                                                            mfirestore.collection("Users").document(auth.getUid())
                                                                                                                                                    .set(userMap)
                                                                                                                                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                                                                                                        @Override
                                                                                                                                                        public void onSuccess(Void aVoid) {
                                                                                                                                                            progressDialog.dismiss();
                                                                                                                                                            Toast.makeText(SubmitITR.this, "Success", Toast.LENGTH_SHORT).show();

                                                                                                                                                            onBackPressed();
                                                                                                                                                        }
                                                                                                                                                    });
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                }
                                                                                                                            });


                                                                                                                        }
                                                                                                                    });
                                                                                                                }
                                                                                                            });


                                                                                                        }
                                                                                                    });
                                                                                                }
                                                                                            });


                                                                                        }
                                                                                    });
                                                                                }
                                                                            });


                                                                        }
                                                                    });
                                                                }
                                                            });


                                                        }
                                                    });
                                                }
                                            });




                                        }
                                    });
                                }
                            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                    double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                                    progressDialog.setMessage(((int) progress) + "% uploading...");
                                }
                            });
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(SubmitITR.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            //final StorageReference riversRef = storageReference.child("Images/Users/PAN/" + edtName.getText().toString() +" "+"PAN"+ ".jpg");
        }




        progressDialog.setTitle("Uploading...");
        progressDialog.show();

        }

 /*   }else{

        Toast.makeText(this, "Password Length must be Greater Than 4", Toast.LENGTH_SHORT).show();

    }*/


}


    }

    private void showFileChooser1() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent, "Select an Image"), PICK_IMAGE_REQUEST_PAN);
    }

    private void showFileChooser2() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent, "Select an Image"), PICK_IMAGE_REQUEST_AADHAAR);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST_PAN && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap
                        (getContentResolver(), filePath);
                imageViewPAN.setImageBitmap(bitmap);

            } catch (IOException e) {
                Log.d("Error", e.getMessage());
            }
        } else if (requestCode == PICK_IMAGE_REQUEST_AADHAAR && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap
                        (getContentResolver(), filePath);
                imageViewAadhaar.setImageBitmap(bitmap);

            } catch (IOException e) {
                Log.d("Error", e.getMessage());
            }
        } else if (requestCode == PICK_IM1 && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap
                        (getContentResolver(), filePath);
                im1.setImageBitmap(bitmap);

            } catch (IOException e) {
                Log.d("Error", e.getMessage());
            }
        } else if (requestCode == PICK_IM2 && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap
                        (getContentResolver(), filePath);
                im2.setImageBitmap(bitmap);

            } catch (IOException e) {
                Log.d("Error", e.getMessage());
            }
        } else if (requestCode == PICK_IM3 && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap
                        (getContentResolver(), filePath);
                im3.setImageBitmap(bitmap);

            } catch (IOException e) {
                Log.d("Error", e.getMessage());
            }
        } else if (requestCode == PICK_DI1 && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap
                        (getContentResolver(), filePath);
                di1.setImageBitmap(bitmap);

            } catch (IOException e) {
                Log.d("Error", e.getMessage());
            }
        } else if (requestCode == PICK_DI2 && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap
                        (getContentResolver(), filePath);
                di2.setImageBitmap(bitmap);

            } catch (IOException e) {
                Log.d("Error", e.getMessage());
            }
        } else if (requestCode == PICK_DI3 && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap
                        (getContentResolver(), filePath);
                di3.setImageBitmap(bitmap);

            } catch (IOException e) {
                Log.d("Error", e.getMessage());
            }
        }




    }
}
