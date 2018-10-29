package com.dev.valmirt.currencyconverter.model

class Currency (var success: Boolean = false,
                var base: String = "",
                var date: String = "",
                var rates: Rates? = null)