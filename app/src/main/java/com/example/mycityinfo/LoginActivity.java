package com.example.mycityinfo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etemail;
    private EditText etpsw;
    private Button loginbtn;
    private FirebaseAuth firebaseAuth;
    private Button signup;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etemail=findViewById(R.id.editText2);
        etpsw=findViewById(R.id.editText4);
        loginbtn=findViewById(R.id.button5);
        firebaseAuth=FirebaseAuth.getInstance();
        signup=findViewById(R.id.button);
        loginbtn.setOnClickListener(this);
        signup.setOnClickListener(this);
        progressDialog = new ProgressDialog(this,R.style.myalertdialog);

    }
    public void userlogin(){
        progressDialog.setTitle("Logging in");
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
        String eml=etemail.getText().toString().trim();
        String psw=etpsw.getText().toString().trim();
        if (TextUtils.isEmpty(eml))
        {
            Toast.makeText(this,"Please enter your email",Toast.LENGTH_SHORT);
            return;
        }
        if (TextUtils.isEmpty(psw))
        {
            Toast.makeText(this,"Please enter your password",Toast.LENGTH_SHORT);
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(eml,psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == loginbtn){
            userlogin();
        }
        if(v == signup){
            Intent i=new Intent(this,SignupActivity.class);
            startActivity(i);
        }
    }
}
