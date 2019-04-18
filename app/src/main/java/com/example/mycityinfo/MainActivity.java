package com.example.mycityinfo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton imageButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == imageButton3)
        {
            Intent i = new Intent(this,Agartala.class);
            startActivity(i);
        }
    }
}





