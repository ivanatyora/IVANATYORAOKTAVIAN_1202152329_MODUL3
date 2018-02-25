package com.example.android.ivanatyoraoktavian_1202152329_modul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailAir extends AppCompatActivity {

    ImageView gambar, battery; //inisiasi variabel bebas
    TextView nama, detail, ukuran;
    int hitungl = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_air);

        //mengatur title bar
        setTitle("Detail Air Minum");

        //Mencari gambar,nama,detail,ukuran, dan battery sesuai dengan id nya
        gambar = findViewById(R.id.detailGambar);
        nama = findViewById(R.id.detailNama);
        detail = findViewById(R.id.detailDesc);
        ukuran = findViewById(R.id.liter);
        battery = findViewById(R.id.battery);


        gambar.setImageDrawable(this.getResources().getDrawable(Integer.valueOf(getIntent().getStringExtra("gambar")))); //mengatur gambar dengan gambar yang di dapat di intent
        nama.setText(getIntent().getStringExtra("nama"));   //mengatur nama pada layout dengan nama yang di dapat intent
        detail.setText(getIntent().getStringExtra("detail"));  //mengatur detail dengan deskripsi yang di dapat dari intent
        battery.setImageLevel(0); //mengatur battery pada level paling rendah
    }

    //method yang akan dieksekusi ketika button minus(-) di klik
    public void minus(View view) {
        if (battery.getDrawable().getLevel() - 1 >= 0) {  //kondisi apabila battery dikurangi sampai satu tingkat sebelum level terendah
            hitungl=hitungl-2; //artinya volume air akan dikurangi sebanyak 2 Liter
            ukuran.setText(hitungl + "L"); //set text view dengan ukuran yang sudah dihitung
            battery.setImageLevel(battery.getDrawable().getLevel() - 1);
        } else {
            battery.setImageLevel(0); //apabila battery dikurangi sampai level paling rendah
            Toast.makeText(this, "Air hampir habis!", Toast.LENGTH_LONG).show(); //memberi pesan bahwa air hampir habis
        }
    }

    //method yang akan dieksekusi ketika button plus di klik
    public void plus(View view) {
        if (battery.getDrawable().getLevel() + 1 <=4) { //kondisi apabila battery ditambah sampai satu tingkat sebelum level tertinggi
            hitungl=hitungl+2;   //volume air akan ditambah sebanyak 2 liter
            ukuran.setText(hitungl + "L"); //set text view dengan ukuran yang sudah dihitung
            battery.setImageLevel(battery.getDrawable().getLevel() + 1);
        } else {
            battery.setImageLevel(4); //apabila level battery penuh
            Toast.makeText(this, "Air sudah penuh!", Toast.LENGTH_LONG).show(); //maka akan muncul toast yang memberi tahu bahwa air sudah penuh
        }
    }
}
