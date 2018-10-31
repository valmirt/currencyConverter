package com.dev.valmirt.currencyconverter.ui.home

import android.Manifest
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.dev.valmirt.currencyconverter.R
import com.dev.valmirt.currencyconverter.adapter.CurrencyAdapter
import com.dev.valmirt.currencyconverter.base.BaseActivity
import com.dev.valmirt.currencyconverter.model.Currency
import com.dev.valmirt.currencyconverter.ui.about.AboutActivity
import com.dev.valmirt.currencyconverter.utils.Constants.Companion.MY_PERMISSIONS_REQUEST
import kotlinx.android.synthetic.main.activity_home.*
import java.math.RoundingMode
import java.text.DecimalFormat

class HomeActivity : BaseActivity<HomeViewModel>() {

    private lateinit var adapter: CurrencyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        adapter = CurrencyAdapter(this)
        list_currency.layoutManager = LinearLayoutManager(this)
        list_currency.setHasFixedSize(true)
        list_currency.adapter = adapter

        viewModel?.errorMessage?.observe(this, Observer { error->
            setErrorResult(error)
        })

        viewModel?.loadingVisibility?.observe(this, Observer { visibility ->
            if (visibility != null) showLoading(visibility)
        })

        viewModel?.resultCurrency?.observe(this, Observer { result ->
            if (result != null && result.success) updateValues(result)
            else getString(R.string.error_message)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_refresh -> {
                viewModel?.loadingCurrency()
                true
            }
            R.id.action_info -> {
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun containerViewModel(): HomeViewModel? {
        requestPermission()
        return ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    private fun setErrorResult(error: String?) {
        if (error != null) Snackbar.make(layout_home, error, Snackbar.LENGTH_LONG).show()
    }

    private fun updateValues(result: Currency) {
        val data = ArrayList<String>(0)
        val df = DecimalFormat("#.##")

        date_converter.text = result.date

        df.roundingMode = RoundingMode.CEILING

        data.add(df.format(result.rates!!.aud))
        data.add(df.format(result.rates!!.brl))
        data.add(df.format(result.rates!!.cad))
        data.add(df.format(result.rates!!.cny))
        data.add(df.format(result.rates!!.jpy))
        data.add(df.format(result.rates!!.rub))
        data.add(df.format(result.rates!!.usd))

        adapter.insertData(data)
    }

    private fun showLoading(setVisibility: Int) {
        loading_screen.visibility = setVisibility
    }

    private fun requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED ) {

            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE), MY_PERMISSIONS_REQUEST)
        } else {

        }
    }
}
