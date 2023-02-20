package com.example.daftarpesanankopinurafifa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DaftarPesanan : AppCompatActivity() {
    private var listpasanan : Int = 0

    private lateinit var harga: TextView
    private lateinit var jumbah: TextView
    private lateinit var recyclerview : RecyclerView
    private lateinit var recyclerviewAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_pesanan)
        val nama = findViewById<EditText>(R.id.txtnama)
        val tpkrim = findViewById<RadioButton>(R.id.rbkrim)
        val tpcoklat = findViewById<RadioButton>(R.id.rbcoklat)
        val tpboba = findViewById<RadioButton>(R.id.rbboba)
        val jmlpesanan = findViewById<EditText>(R.id.jmbpesanan)
        val pesan = findViewById<Button>(R.id.btnpesan)
        val hasilList = findViewById<TextView>(R.id.hasilpesanan)
        val simpan = findViewById<TextView>(R.id.simpan)
        val hargakopi = findViewById<EditText>(R.id.hargakopi)
        recyclerview = findViewById(R.id.listdata)




        val data = mutableListOf<Datapesanan>()
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerviewAdapter = adapterPesanan(data)
        recyclerview.adapter= recyclerviewAdapter
        recyclerview.layoutManager= viewManager

        //Text Simpan
        simpan.setOnClickListener{
            val nama = nama.text.toString()
            val harga = hargakopi.text.toString()
            val jumblah =jmlpesanan.text.toString()
            val total = hasilList.text.toString()

            val DataKalkulator = Datapesanan(nama,harga,jumblah,total)
            data.add(DataKalkulator)
            recyclerviewAdapter.notifyDataSetChanged()
        }



    pesan.setOnClickListener {

            var nama = nama.text.toString()
            var jmb = jmlpesanan.text.toString().toInt()
            var hargakopi = hargakopi.text.toString().toInt()


            if (tpkrim.isChecked){
              listpasanan = ((hargakopi) * (jmb))
              hasilList.setText("Toping       : Krim \nTotal          : " + listpasanan.toString() )

        }else if (tpcoklat.isChecked){
                listpasanan = ((hargakopi) * (jmb))
                hasilList.setText("Toping       : Coklat \nTotal           : " + listpasanan.toString() )

            }else if (tpboba.isChecked){
                listpasanan = ((hargakopi) * (jmb))
                hasilList.setText("Toping       : Boba \nTotal          : " + listpasanan.toString() )

            } else{
                hasilList.setText("Pilih toping Dulu")
            }


        }
    }
}