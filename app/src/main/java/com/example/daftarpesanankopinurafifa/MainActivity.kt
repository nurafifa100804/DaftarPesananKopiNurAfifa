package com.example.daftarpesanankopinurafifa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun masuk (view: View){
        val pindah = Intent(this,DaftarPesanan::class.java)
        startActivity(pindah)
    }
}