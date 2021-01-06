package com.example.penjualan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_view.*

class DetailActivity : AppCompatActivity() {


    companion object {

        //wadah variable untuk data yang di kirim dari adapter

        var INTENT_GAMBAR_PENJUALAN = null
        var INTENT_NAMA_PENJUALAN = "NAMA_PENJUALAN"
        var INTENT_HARGA_PENJUALAN = "HARGA_PENJUALAN"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // intent.getStringExtra(INTENT_NAMA_PENJUALAN) untuk mengambil data yang di kirim dari adapter

        var namaDetailPenjualan   = intent.getStringExtra(INTENT_NAMA_PENJUALAN)
        var hargaDetailPenjualan  = intent.getStringExtra(INTENT_HARGA_PENJUALAN)
            .orEmpty()
        val gambarDetailPenjualam  = intent.getIntExtra(INTENT_GAMBAR_PENJUALAN,
            0)

        val a = findViewById<TextView>(R.id.tvHargaPakaian)


        // untuk menghubungkan data yang di terima kepada widget yang kita miliki

        tvHargaDetailPakaian.text = hargaDetailPenjualan
        tvNamaDetailPakaian.text = namaDetailPenjualan


        Glide.with(this)
            .load(gambarDetailPenjualam)
            .into(imgDetailPakaian)

    }
}