package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class manhinhchao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchao);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }
        },2500);

    }
}