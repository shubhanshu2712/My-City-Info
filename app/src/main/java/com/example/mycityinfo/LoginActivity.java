package com.example.mycityinfo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etemail=findViewById(R.id.editText2);
        etpsw=findViewById(R.id.editText4);
        loginbtn=findViewById(R.id.button5);
        firebaseAuth=FirebaseAuth.getInstance();

        loginbtn.setOnClickListener(this);
    }
    public void userlogin(){
        String eml=etemail.getText().toString().trim();
        String psw=etpsw.getText().toString().trim();
        firebaseAuth.signInWithEmailAndPassword(eml,psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
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
    }
}
