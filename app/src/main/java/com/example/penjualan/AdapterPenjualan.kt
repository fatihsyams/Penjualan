package com.example.penjualan

import android.content.Context
import android.content.Intent
import android.content.res.TypedArray
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class AdapterPenjualan(
    val namaPenjualan: Array<String>,
    val hargaPenjualan: Array<String>,
    val gambarPenjualan: TypedArray
) : RecyclerView.Adapter<AdapterPenjualan.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

       // MENGHUBUNGKAN ANTARA ITEM_VIEW KEPADA RECYCLERVIEW

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return gambarPenjualan.length()
    }

    override fun onBindViewHolder(holder: AdapterPenjualan.ViewHolder, position: Int) {

        holder.tvNama.text = namaPenjualan[position]
        holder.tvHarga.text = hargaPenjualan[position]

        Glide.with(holder.itemView.context)
            .load(gambarPenjualan.getResourceId(position, -1))
            .into(holder.gambar)


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            // put Extra untuk mengirim data ke class tujuan
            intent.putExtra(DetailActivity.INTENT_HARGA_PENJUALAN, hargaPenjualan[position])
            intent.putExtra(
                DetailActivity.INTENT_GAMBAR_PENJUALAN,
                gambarPenjualan.getResourceId(position, -1)
            )
            intent.putExtra(DetailActivity.INTENT_NAMA_PENJUALAN, namaPenjualan[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // memberi tahu ke sistem , bahwa kita memiliki 3 widget di layout

        internal var tvHarga: TextView
        internal var tvNama: TextView
        internal var gambar: ImageView
//        internal lateinit var Keterangan: TextView

        init {

            // menghubungkan antara variable ke ID Widget

            tvHarga = itemView.findViewById(R.id.tvHargaPakaian)
            tvNama = itemView.findViewById(R.id.tvNamaPakaian)
            gambar = itemView.findViewById(R.id.imgPakaian)
        }
    }

}