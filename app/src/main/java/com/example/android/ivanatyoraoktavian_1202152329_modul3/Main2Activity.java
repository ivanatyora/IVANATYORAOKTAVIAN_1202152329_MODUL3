package com.example.android.ivanatyoraoktavian_1202152329_modul3;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    RecyclerView recv;
    ListMinuman adptr;
    List<menulist> daftarmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        setTitle("Daftar Air Mineral"); //mengatur title bar menjadi Daftar Air Mineral

        daftarmenu = new ArrayList<>();  //membuat array list baru dengan nama daftarmenu
        recv = findViewById(R.id.recycle); //mendapat penanganan recycler view
        recv.setHasFixedSize(true);

        //kondisi ketika orientasi menjadi landscape
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            recv.setLayoutManager(new GridLayoutManager(Main2Activity.this, 2));  //menampilkan 2 grid

        }else { //kondisi jika orientasi menjadi portrait
            recv.setLayoutManager(new GridLayoutManager(Main2Activity.this, 1)); //menampilkan 1 grid
        }
        inputdata(); //menjalankan fungsi input data
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation== Configuration.ORIENTATION_LANDSCAPE){
            recv.setLayoutManager(new GridLayoutManager(Main2Activity.this, 2));
        }else {
            recv.setLayoutManager(new GridLayoutManager(Main2Activity.this, 1));
        }
    }

    public void inputdata(){
        //memasukkan data ke dalam array
        daftarmenu.add(new menulist(R.drawable.ades, "Ades", "Ini adalah air mineral Ades. \nAdes merupakan sebuah air mineral atau air minum dalam kemasan (AMDK) yang diproduksi oleh PT. Coca-Cola Bottling Indonesia, Bekasi."));
        daftarmenu.add(new menulist(R.drawable.amidis,"Amidis", "Ini adalah air mineral Amidis. \nAMIDIS merupakan produk Air Minum Dalam Kemasan (AMDK) yang sudah diproduksi sejak tahun 1997 dan merupakan air minum distilasi pertama di Indonesia yang telah menjadi salah satu produk AMDK yang dipercaya karena kualitas mutu dan kemurniannya."));
        daftarmenu.add(new menulist(R.drawable.aqua, "Aqua", "Ini adalah air mineral Aqua. \nAqua merupakan sebuah merek air minum dalam kemasan (AMDK) yang diproduksi oleh PT Aqua Golden Mississippi Tbk di Indonesia sejak tahun 1973. Selain di Indonesia, Aqua juga dijual di Malaysia, Singapura, dan Brunei."));
        daftarmenu.add(new menulist(R.drawable.cleo, "Cleo", "Ini adalah air mineral Cleo. \nAir Murni Cleo diambil dari mata air pegunungan dan diproses melalui hyper membrane filter 0,0001 mikron sehingga tidak mengandung mikroorganisme dan mineral anorganik, misalnya chlorine dan natrium fluoride."));
        daftarmenu.add(new menulist(R.drawable.club, "Club", "Ini adalah air minum mineral Club. \nClub merupakan sebuah air minum dalam kemasan atau air mineral di Indonesia. Merek ini berasal dari Surabaya dan Pandaan, Pasuruan, Jawa Timur. Club diproduksi oleh PT Tirta Sukses Perkasa (dahulu PT Tirta Bahagia) sejak tahun 1986. Pada bulan November 2013, merek Club diakuisisi oleh PT Indofood CBP Sukses Makmur Tbk."));
        daftarmenu.add(new menulist(R.drawable.equil, "Equil", "Ini adalah air mineral Equil. \nEquil merupakan air mineral anorganik yang di produksi oleh PT Equilindo Asri. Sedang pemilik PT Equilindo Asri adalah Morgen Sutanto. Untuk lokasi industrinya berada di Vila D’Equilibrium, dan pabrik pengemasan Equil terletak di kaki Gunung Salak, Sukabumi, Jawa Barat."));
        daftarmenu.add(new menulist(R.drawable.evian, "Evian", "Ini adalah air mineral Evian. \nEvian merupakan air mineral alami berasal dari satu sumber di puncak pegunungan Alpen, Perancis. Setiap tetesnya melewati perjalanan dan proses alam selama 15 tahun sebelum muncul di mata air. Pembentukan mineral terjadi selama proses alami tersebut, melewati lapisan es dan bebatuan, dalam komposisi yang unik. "));
        daftarmenu.add(new menulist(R.drawable.leminerale, "leMinerale", "Ini adalah air mineral leMinerale. \nLe Air mineral baru dari Mayora, berupa air mineral pegunungan yang mengandung mineral alami yang dibutuhkan tubuh sehari-hari. Le Minerale, diolah dari sumber mata air pegunungan terpilih, sehingga memiliki kesegaran khas yang ditandai dengan sedikit rasa manis."));
        daftarmenu.add(new menulist(R.drawable.nestle, "Nestle", "Ini adalah air mineral Nestle. \nKesegaran tak tergantikan dari Nestlé Pure Life Mineral Water yang berasal dari segala kemurnian mata air pilihan dan diproses secara higienis. Spesifikasi Produk. Jenis Produk: Air Mineral. Isi: 1500ml."));
        daftarmenu.add(new menulist(R.drawable.pristine, "Pristine", "Ini adalah air mineral Pristine. \nAir minum yang bersih adalah air minum beralkali yang di proses ionisasi, air minum pristine adalah air alkali dengan ph 8 yang bermanfaat untuk kesehatan, air minum kemasan praktis dan ekonomis."));
        daftarmenu.add(new menulist(R.drawable.vit, "Vit", "Ini adalah air mineral Vit. \nVIT adalah sebuah merek air minum dalam kemasan (AMDK) yang diproduksi oleh PT Tirta Investama di Indonesia. Mulai diproduksi sejak tanggal 16 November 1982 dan awalnya dimiliki oleh PT Varia Industri Tirta."));

        adptr = new ListMinuman(this,daftarmenu);  //membuat adapter baru yang menghubungkan kelas ini dengan data yang ingin ditampilkan
        recv.setAdapter(adptr);       //menguhubungkan recycler view dengan adapter
    }
}
