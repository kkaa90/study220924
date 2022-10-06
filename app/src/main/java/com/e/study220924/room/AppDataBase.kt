package com.e.study220924.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.e.study220924.room.dao.UserDao
import com.e.study220924.room.entity.DateConverters
import com.e.study220924.room.entity.UserEntity
import com.e.study220924.room.entity.UserSkillEntity

@Database(entities = [UserEntity::class, UserSkillEntity::class], version = 1)
@TypeConverters(DateConverters::class)
abstract class AppDataBase : RoomDatabase(){
    abstract fun userDao() : UserDao
}