package com.example.penjualan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var email = "asep@gmail.com"
    var pass = "asdfghj"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            if (edtEmailLogin.text.toString().isEmpty() ||
                edtPasswordLogin.text.toString().isEmpty()
            ) {
                edtEmailLogin.error = "isi datanya dlu om"
                edtPasswordLogin.error = "isi datanya dlu om"
            } else {
                if (edtEmailLogin.text.toString() == email &&
                    edtPasswordLogin.text.toString() == pass
                ) {
                    Toast.makeText(
                        this, "Anda Berhasil Login",
                        Toast.LENGTH_LONG
                    ).show()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this, "Data Anda Salah",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    }
}