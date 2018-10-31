package com.dev.valmirt.currencyconverter.ui.about

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dev.valmirt.currencyconverter.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        text_2.setOnClickListener {
            val uri = Uri.parse("https://fixer.io/documentation")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        text_3.setOnClickListener {
            val uri = Uri.parse("https://github.com/valmirt/currencyConverter")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}
