package com.dev.valmirt.currencyconverter.model

import com.google.gson.annotations.SerializedName

class Rates (@SerializedName("AUD") var aud: Double = 0.0,
             @SerializedName("BRL") var brl: Double = 0.0,
             @SerializedName("CAD") var cad: Double = 0.0,
             @SerializedName("CHF") var chf: Double = 0.0,
             @SerializedName("CNY") var cny: Double = 0.0,
             @SerializedName("JPY") var jpy: Double = 0.0,
             @SerializedName("USD") var usd: Double = 0.0)