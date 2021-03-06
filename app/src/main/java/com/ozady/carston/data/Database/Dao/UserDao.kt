package com.ozady.carston.data.Database.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ozady.carston.data.Database.Model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User):Long

    @Query("DELETE FROM user")
    suspend fun deleteAll()

    @Query("SELECT * FROM user where userid = :id")
    fun getuser(id: Int): LiveData<User>

}