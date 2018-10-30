package com.dev.valmirt.currencyconverter.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dev.valmirt.currencyconverter.R
import com.dev.valmirt.currencyconverter.model.Country

class CurrencyAdapter (var context: Context) : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private var list = ArrayList<Country>(0)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val noteView = inflater.inflate(R.layout.item_list, parent, false)
        return CurrencyViewHolder(noteView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val item = list[position]
        holder.fillData(item, context)
    }

    inner class CurrencyViewHolder(noteView: View): RecyclerView.ViewHolder(noteView){
        private val image = noteView.findViewById<ImageView>(R.id.image_country)
        private val textName = noteView.findViewById<TextView>(R.id.name_country)
        private val textCurrency = noteView.findViewById<TextView>(R.id.value_currency)

        @SuppressLint("SetTextI18n")
        fun fillData(data: Country, context: Context){
            textName.text = data.name+" ("+data.id+")"
            when(data.id){
                "AUD"->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.aud_flag))
                    textCurrency.text = "$"+data.currency
                }
                "BRL"->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.brl_flag))
                    textCurrency.text = "R$"+data.currency
                }
                "CAD"->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.cad_flag))
                    textCurrency.text = "C$"+data.currency
                }
                "CNY"->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.cny_flag))
                    textCurrency.text = "¥"+data.currency
                }
                "JPY"->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.jpy_flag))
                    textCurrency.text = "JP¥"+data.currency
                }
                "RUB"->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.rub_flag))
                    textCurrency.text = "\u20BD"+data.currency
                }
                "USD"->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.usd_flag))
                    textCurrency.text = "US$"+data.currency
                }
            }
        }
    }
}