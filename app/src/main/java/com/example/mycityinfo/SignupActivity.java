package com.example.mycityinfo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText textemail;
    private EditText textpassword;
    private EditText textcnfpassword;
    private Button signup;
    private Button login;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        textemail = findViewById(R.id.editText);
        textpassword = findViewById(R.id.editText3);
        textcnfpassword = findViewById(R.id.editText5);
        signup = findViewById(R.id.button4);
        login = findViewById(R.id.button2);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this,R.style.myalertdialog);

        signup.setOnClickListener(this);
        login.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == login)
        {
            Intent i = new Intent(this,LoginActivity.class);
            startActivity(i);
        }
        if(v == signup)
        {
            signitup();
        }

    }
    public void signitup()
    {
        String email = textemail.getText().toString().trim();
        String password = textpassword.getText().toString();
        String cnfpassword = textcnfpassword.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Please enter a password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(cnfpassword))
        {
            Toast.makeText(this,"Please re-enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!TextUtils.equals(password,cnfpassword))
        {
            Toast.makeText(this,"Passwords does not match",Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            progressDialog.setTitle("Signing Up");
            progressDialog.setMessage("Please Wait...");
            progressDialog.show();
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    if(task.isSuccessful())
                    {
                        Toast.makeText(SignupActivity.this, "Signed up successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(SignupActivity.this,"Failed to sign up",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
