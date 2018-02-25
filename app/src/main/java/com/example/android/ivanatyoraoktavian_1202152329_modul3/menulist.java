package com.example.android.ivanatyoraoktavian_1202152329_modul3;


public class menulist {
    //deklarasi variable yang akan digunakan
    int gambar;
    String nama;
    String desc;

    //method setter
    public menulist(int gambar, String nama, String desc){
        this.gambar=gambar;
        this.nama=nama;
        this.desc=desc;
    }

    public int getGambar() {
        return gambar;
    }  //method getter untuk mendapatkan gambar
    public String getNama() {
        return nama;
    } //method getter untuk mendapatkan nama
    public String getDesc() {
        return desc;
    } //method getter untuk get detail

}
