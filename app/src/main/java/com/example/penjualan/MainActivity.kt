package com.example.penjualan

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: AdapterPenjualan
    lateinit var namaPenjualan: Array<String>
    lateinit var hargaPenjualan: Array<String>
    lateinit var gambarPenjualan: TypedArray


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        namaPenjualan = resources.getStringArray(R.array.nama_pakaian)
        hargaPenjualan = resources.getStringArray(R.array.harga_pakaian)
        gambarPenjualan = resources.obtainTypedArray(R.array.gambar_pakaian)


        adapter = AdapterPenjualan(
             namaPenjualan,
            hargaPenjualan,gambarPenjualan
        )


        rvPenjualan.setHasFixedSize(true)
        rvPenjualan.layoutManager = LinearLayoutManager(this@MainActivity)
        rvPenjualan.adapter = adapter




    }


}