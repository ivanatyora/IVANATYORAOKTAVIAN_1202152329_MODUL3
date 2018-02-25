package com.example.android.ivanatyoraoktavian_1202152329_modul3;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;


public class ListMinuman extends RecyclerView.Adapter<ListMinuman.holdermn> {
    private Context context;
    private List<menulist> daftarmenu;

    //adpater yang akan menyiapkan layout untuk list minuman
    public ListMinuman(Context context, List<menulist> daftarmenu) {
        this.context = context;
        this.daftarmenu = daftarmenu;
    }

    @Override
    //membuat suatu tampilan dan mengembalikannya
    public holdermn onCreateViewHolder(ViewGroup parent, int viewType) {
        //membuat view baru
        View vw = LayoutInflater.from(context).inflate(R.layout.listminuman, parent, false);
        holdermn hldr = new holdermn(vw);
        return hldr;
    }

    @Override
    //menghubungkan data dengan view holder pada posisi yang ditentukan dalam RecyclerView
    public void onBindViewHolder(holdermn holder, int position) {
        menulist dt = daftarmenu.get(position); //mengambil elemen dari array pada posisi tertentu
        holder.nama.setText(dt.getNama());  //mengeset isi view dengan elemen dari data
        holder.detail.setText(dt.getDesc());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) { //kondisi gambar dari drawable dijadikan sebagai background dari cardview
            holder.rl.setBackground(holder.rl.getResources().getDrawable(dt.getGambar()));
        }
        holder.rl.setTag(dt.getGambar());
    }

    @Override

    // menghitung ukuran dataset/jumlah data yang akan ditampilkan
    public int getItemCount() {
        return daftarmenu.size();
    }

    class holdermn extends RecyclerView.ViewHolder{

        TextView nama, detail;  //deklarasi variable
        RelativeLayout rl;
        public holdermn(View itemView) {
            super(itemView);
            //mengakses nama, detail, dan rl yang ada pada layout
            nama = itemView.findViewById(R.id.namaAir);
            detail = itemView.findViewById(R.id.detailAir);
            rl = itemView.findViewById(R.id.rl);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                //ketika cardview di klik
                public void onClick(View view) { //implementasi onclicklistener

                    Intent move = new Intent(context, DetailAir.class); //membuat intent
                    move.putExtra("nama", nama.getText()); //mengirimkan data data yang diambil ke detail air untuk di tampilkan
                    move.putExtra("detail", detail.getText());
                    move.putExtra("gambar",rl.getTag().toString());
                    context.startActivity(move);
                }
            });
        }
    }
}