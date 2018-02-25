package com.example.android.ivanatyoraoktavian_1202152329_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Handler handler = new Handler(); //mendeklarasikan objek handler

        handler.postDelayed(new Runnable() { //mengatur lama waktu menjalankan splash screen
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 5000L); //lamanya splash --> 5 detik
    }
    }

