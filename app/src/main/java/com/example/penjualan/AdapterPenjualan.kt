package com.example.penjualan

import android.content.Context
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
    val gambarPenjualan : TypedArray
) : RecyclerView.Adapter<AdapterPenjualan.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPenjualan.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
       return gambarPenjualan.length()
    }

    override fun onBindViewHolder(holder: AdapterPenjualan.ViewHolder, position: Int) {

        holder.tvNama.text = namaPenjualan[position]
        holder.tvHarga.text = hargaPenjualan[position]
        Log.d(namaPenjualan[position],"DATA_NAMA")

        Glide.with(holder.itemView.context)
            .load(gambarPenjualan.getResourceId(position, -1))
            .into(holder.gambar)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        internal  var tvHarga : TextView
        internal  var tvNama : TextView
        internal  var gambar : ImageView

        init {
            tvHarga = itemView.findViewById(R.id.tvHargaPakaian)
            tvNama = itemView.findViewById(R.id.tvNamaPakaian)
            gambar = itemView.findViewById(R.id.imgPakaian)
        }
    }

}