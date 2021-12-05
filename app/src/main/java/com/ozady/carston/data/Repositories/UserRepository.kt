package com.ozady.carston.data.Repositories

import com.ozady.carston.data.Database.Dao.SettingDao
import com.ozady.carston.data.Database.Dao.UserDao
import com.ozady.carston.data.Database.Model.Setting
import com.ozady.carston.data.Database.Model.User

class UserRepository(var userDao: UserDao, var settingDao: SettingDao) {

    var getUsers = userDao.getAll()

    suspend fun addUser(user: User){
        userDao.insert(user)
    }

    suspend fun deleteAllUser(){
        userDao.deleteAll()
    }

    var getSetting = settingDao.getAll()

    suspend fun addSetting (setting: Setting){
        settingDao.insert(setting)
    }

    suspend fun deleteAllSetting (){
        settingDao.deleteAll()
    }

    fun getUser(id: Int) = userDao.getuser(id)

}