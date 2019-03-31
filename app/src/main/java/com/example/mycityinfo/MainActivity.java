package com.example.mycityinfo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MyCityInfo(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/dir/Dharmanagar,+Tripura/Agartala,+Tripura/@24.0853034,91.4436361,10z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x3751ece5d004e9d1:0x7aea66e60718b4f5!2m2!1d92.1548473!2d24.3783242!1m5!1m1!1s0x3753f40dc94123a7:0xd0a1263c6c40c8c7!2m2!1d91.2867777!2d23.831457"));
        startActivity(browserIntent);
    }
}





