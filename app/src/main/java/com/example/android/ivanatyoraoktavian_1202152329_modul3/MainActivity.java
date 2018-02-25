package com.example.android.ivanatyoraoktavian_1202152329_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password; //membuat variabel bebas


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        username=(EditText)findViewById(R.id.et_username); //implementasi input username dengan id yang sudah dibuat
        password=(EditText)findViewById(R.id.et_password); //implementasi input password dengan id yang sudah dibuat

        //Membuat kondisi username=EAD dan password=MOBILE
        if (username.getText().toString().equals("EAD")&&password.getText().toString().equals("MOBILE")) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Login berhasil", Toast.LENGTH_SHORT).show(); //pesan apabila kondisi login berhasil
        }else {
            Toast.makeText(getApplicationContext(), "Login gagal", Toast.LENGTH_SHORT).show(); //pesan apabila username dan password tidak sesuai
        }
    }

}
