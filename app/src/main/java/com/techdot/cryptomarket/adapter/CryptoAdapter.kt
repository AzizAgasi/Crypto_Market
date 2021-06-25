package com.techdot.cryptomarket.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.techdot.cryptomarket.network.CryptoModel
import androidx.recyclerview.widget.DiffUtil
import com.techdot.cryptomarket.R
import com.techdot.cryptomarket.network.CryptoMarket

class CryptoAdapter(private var cryptoData: List<CryptoModel>?,
                    private var context: Context):
    RecyclerView.Adapter<CryptoAdapter.ViewHolder>() {


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val coinTextView: TextView = itemView.findViewById(R.id.coin)
        val priceTextView: TextView = itemView.findViewById(R.id.price)
        val percentTextView: TextView = itemView.findViewById(R.id.percentChange)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.crypto_data_layout, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData = cryptoData?.get(position)
        holder.coinTextView.text = currentData?.coin
        holder.priceTextView.text = currentData?.price.toString()
        holder.percentTextView.text = currentData?.change.toString()
    }

    override fun getItemCount(): Int {
        return cryptoData!!.size
    }
}