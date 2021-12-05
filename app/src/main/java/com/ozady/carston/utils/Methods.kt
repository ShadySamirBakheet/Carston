package com.ozady.carston.utils

import android.app.Activity
import androidx.appcompat.app.AppCompatDelegate
import com.ozady.carston.views.settings.AppSettingsActivity
import java.util.*

class Methods {

    companion object{

        fun setLocale(languageCode: String?,activity: Activity) {
            val locale = Locale(languageCode)
            Locale.setDefault(locale)
            val resources = activity.resources
            val config = resources.configuration
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
        }

        fun changeThemeFun(dark: Boolean) {
            if(dark){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            AppSettingsActivity.appSetting = false
        }


    }

}