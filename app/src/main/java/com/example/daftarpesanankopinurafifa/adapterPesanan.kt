package com.example.daftarpesanankopinurafifa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterPesanan (private val dataset: MutableList<Datapesanan>):
    RecyclerView.Adapter<adapterPesanan.SiswaHolder>(){
    class SiswaHolder(view: View): RecyclerView.ViewHolder(view) {
        val nama =view.findViewById<TextView>(R.id.txtnama)
        val harga =view.findViewById<TextView>(R.id.txtharga)
        val jumblah  =view.findViewById<TextView>(R.id.txtjumblah)
        val total  =view.findViewById<TextView>(R.id.txttotal)
        val btnHps =view.findViewById<TextView>(R.id.btnHps)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiswaHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter_pesanan,parent,false
        )
        return SiswaHolder(view)
    }

    override fun onBindViewHolder(holder: SiswaHolder, position: Int) {
        val data = dataset[position]
        holder.nama.text=dataset[position].Nama
        holder.harga.text=dataset[position].Harga
        holder.jumblah.text=dataset[position].Jumblah
        holder.total.text=dataset[position].Total
        holder.btnHps.setOnClickListener{
            dataset.removeAt(position)
            notifyItemRangeRemoved(position,dataset.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}