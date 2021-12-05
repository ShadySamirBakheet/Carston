package com.ozady.carston.views.settings

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ozady.carston.R
import com.ozady.carston.adapters.data.Utlis.CountryAdapter
import com.ozady.carston.data.ViewModels.UserViewModel
import com.ozady.carston.databinding.ActivityAppSettingsBinding
import com.ozady.carston.adapters.data.Utlis.CurrencyAdapter
import com.ozady.carston.data.Database.Model.Setting
import com.ozady.carston.utils.Methods.Companion.changeThemeFun
import com.ozady.carston.utils.Methods.Companion.setLocale
import com.ozady.carston.views.home.MainActivity
import com.ozady.carston.views.login_system.LoginActivity
import java.util.*

class AppSettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppSettingsBinding

    private lateinit var viewModel: UserViewModel

    lateinit var country_list: RecyclerView

    lateinit var currency_list: RecyclerView

    lateinit var EnBtn: RelativeLayout
    lateinit var ArBtn: RelativeLayout
    lateinit var darkBtn: RelativeLayout
    lateinit var lightBtn: RelativeLayout

    lateinit var darkSelect: ImageView
    lateinit var lightSelect: ImageView
    lateinit var btnNext: ImageView
    lateinit var enSelect: ImageView
    lateinit var arSelect: ImageView


    companion object{
        var appSetting = false
        var isEN = false
        var isDark = false
        var isMain = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        country_list = binding.countryList
        currency_list = binding.currencyList
        EnBtn = binding.EnBtn
        ArBtn = binding.ArBtn
        enSelect = binding.enSelect
        arSelect = binding.arSelect
        darkBtn = binding.darkBtn
        lightBtn = binding.lightBtn
        darkSelect = binding.darkSelect
        lightSelect = binding.lightSelect
        btnNext = binding.btnNext

        appSetting = intent.getBooleanExtra("appSetting",false)
        isMain = intent.getBooleanExtra("isMain",false)

        darkSelect.visibility = VISIBLE
        lightSelect.visibility = GONE

        if (appSetting){
            val viewmodel = ViewModelProvider(this).get(UserViewModel::class.java)
            viewmodel.getSetting.observe(this,{
                if (it.size > 0){
                    isEN = it[0].isEN == true
                    isDark = it[0].isDark == true
                    changeFun()
                }
            })
        }else{
            changeFun()
        }

        EnBtn.setOnClickListener {
            isEN = true
            enSelect.visibility = VISIBLE
            arSelect.visibility = GONE
        }

        ArBtn.setOnClickListener {
            isEN = false
            enSelect.visibility = GONE
            arSelect.visibility = VISIBLE
        }

        darkBtn.setOnClickListener {
            isDark = true
            //Toast.makeText(this, "$isDark", Toast.LENGTH_SHORT).show()
            darkSelect.visibility = VISIBLE
            lightSelect.visibility = GONE
            changeThemeFun(isDark)
        }

        lightBtn.setOnClickListener {
            isDark = false
            //Toast.makeText(this, "$isDark", Toast.LENGTH_SHORT).show()
            darkSelect.visibility = GONE
            lightSelect.visibility = VISIBLE
            changeThemeFun(isDark)
        }

        btnNext.setOnClickListener {
            goNextFun()
        }

        country_list.setHasFixedSize(true)
        country_list.layoutManager = LinearLayoutManager(this)
        country_list.adapter = CountryAdapter(this)

        currency_list.setHasFixedSize(true)
        currency_list.layoutManager = LinearLayoutManager(this)
        currency_list.adapter = CurrencyAdapter(this)

    }

    private fun changeFun() {
        if (isEN){
            enSelect.visibility = VISIBLE
            arSelect.visibility = GONE
            setLocale("en",this)
        }else{
            enSelect.visibility = GONE
            arSelect.visibility = VISIBLE
            setLocale("ar",this)
        }

        if (isDark){
            darkSelect.visibility = VISIBLE
            lightSelect.visibility = GONE
            changeThemeFun(isDark)
        }else{
            darkSelect.visibility = GONE
            lightSelect.visibility = VISIBLE
            changeThemeFun(isDark)
        }
    }



    private fun goNextFun() {
        val viewmodel = ViewModelProvider(this).get(UserViewModel::class.java)

        Toast.makeText(this, "$isDark isDark", Toast.LENGTH_SHORT).show()

        viewmodel.deleteAllSetting()
        viewmodel.addSetting(Setting(isEN,isDark,getString(R.string.egypt),getString(R.string.egp)))

        if (isEN){
            setLocale("en",this)
        }else{
            setLocale("ar",this)
        }

        if (isMain){
            startActivity(
                Intent(this, LoginActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TASK))
            finish()
        }else{
            startActivity(
                Intent(this, MainActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TASK))
            finish()
        }

    }

}