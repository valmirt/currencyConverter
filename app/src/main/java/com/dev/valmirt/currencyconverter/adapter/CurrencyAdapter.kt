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

class CurrencyAdapter (var context: Context) : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private var list = ArrayList<String>(0)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val noteView = inflater.inflate(R.layout.item_list, parent, false)
        return CurrencyViewHolder(noteView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val item = list[position]
        holder.fillData(item, position, context)
    }

    fun insertData(data: List<String>){
        this.list.clear()
        this.list.addAll(data)
        notifyDataSetChanged()
    }

    inner class CurrencyViewHolder(noteView: View): RecyclerView.ViewHolder(noteView){
        private val image = noteView.findViewById<ImageView>(R.id.image_country)
        private val textName = noteView.findViewById<TextView>(R.id.name_country)
        private val textCurrency = noteView.findViewById<TextView>(R.id.value_currency)

        @SuppressLint("SetTextI18n")
        fun fillData(data: String, position: Int, context: Context){
            when(position){
                0 ->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.aud_flag))
                    textName.text = context.getString(R.string.aud_name)
                    textCurrency.text = "$$data"
                }
                1 ->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.brl_flag))
                    textName.text = context.getString(R.string.brl_name)
                    textCurrency.text = "R$$data"
                }
                2->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.cad_flag))
                    textName.text = context.getString(R.string.cad_name)
                    textCurrency.text = "C$$data"
                }
                3 ->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.cny_flag))
                    textName.text = context.getString(R.string.cny_name)
                    textCurrency.text = "¥$data"
                }
                4->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.jpy_flag))
                    textName.text = context.getString(R.string.jpy_name)
                    textCurrency.text = "JP¥$data"
                }
                5->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.rub_flag))
                    textName.text = context.getString(R.string.rub_name)
                    textCurrency.text = "₽$data"
                }
                6->{
                    image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.usd_flag))
                    textName.text = context.getString(R.string.usd_name)
                    textCurrency.text = "US$$data"
                }
            }
        }
    }
}