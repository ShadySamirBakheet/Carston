package com.ozady.carston.data.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ozady.carston.data.Database.DataBase.DataBase
import com.ozady.carston.data.Database.Model.Setting
import com.ozady.carston.data.Database.Model.User
import com.ozady.carston.data.Repositories.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {

    private var repository : UserRepository
    val getUsers : LiveData<List<User>>
    val getSetting : LiveData<List<Setting>>

    init {
        val dataBase = DataBase.getDatabase(application.applicationContext)

        val userDao = dataBase.userDao()
        val settingDao = dataBase.settingDao()

        repository = UserRepository(userDao,settingDao)

        getUsers = repository.getUsers
        getSetting = repository.getSetting

    }

    fun getUser(id:Int)= repository.getUser(id)

    private fun addUser(user: User) = viewModelScope.launch {
        repository.addUser(user)
    }

    fun deleteAllUser() = viewModelScope.launch {
        repository.deleteAllUser()
    }

    fun addSetting(setting: Setting) = viewModelScope.launch {
        repository.addSetting(setting)
    }

    fun deleteAllSetting() = viewModelScope.launch {
        repository.deleteAllSetting()
    }


}