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

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etemail;
    private EditText etpsw;
    private EditText etcpsw;
    private Button loginbtn;
    private FirebaseAuth firebaseAuth;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etemail=findViewById(R.id.editText);
        etpsw=findViewById(R.id.editText3);
        loginbtn=findViewById(R.id.button2);
        firebaseAuth=FirebaseAuth.getInstance();
        signup=findViewById(R.id.button4);
        loginbtn.setOnClickListener(this);
        signup.setOnClickListener(this);

    }
    public void userlogin(){
        String eml=etemail.getText().toString().trim();
        String psw=etcpsw.getText().toString().trim();
        String cpsw =etcpsw.getText().toString().trim();
        firebaseAuth.signInWithEmailAndPassword(eml,psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent i = new Intent(SignupActivity.this,MainActivity.class);
                    Toast.makeText(SignupActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                    startActivity(i);
                }


            }
        });
    }

    @Override
    public void onClick(View v) {

        if(v == loginbtn){
            Intent i=new Intent(this,LoginActivity.class);
            startActivity(i);
        }
    }
}
