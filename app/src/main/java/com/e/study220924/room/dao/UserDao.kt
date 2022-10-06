package com.e.study220924.room.dao

import androidx.room.*
import com.e.study220924.room.entity.UserEntity
import com.e.study220924.room.entity.UserSkillEntity

@Dao
interface UserDao {
    @Query("select u.id as id, u.email as email, u.password as password from users u limit 1")
    fun getExistUserLoginInfo() : LoginInfo?

    @Query("select * from users limit 1")
    fun getUser(): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user: UserEntity)

    @Update
    fun updateUser(user : UserEntity)

    @Delete
    fun deleteUser(user : UserEntity)


    data class LoginInfo(val id : Long, val email : String, val password : String)

    @Query("select * from skills where userId = :userId")
    fun getUserSkills(userId : Long) : List<UserSkillEntity>?

    @Query("select * from skills where id = :id")
    fun getUserSkillById(id : Long) : UserSkillEntity

    @Query("select id from skills where userId = :userId")
    fun getUserSkillIdByUserId(userId : Long) : List<Long>?

    @Query("select * from skills where userId = :userId and name like :keyword")
    fun searchUserSkillByKeyword(userId: Long, keyword : String) : List<UserSkillEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUserSkill(skill : UserSkillEntity)

    @Query("update skills set level = :nextLevel where id = :id")
    fun updateUserSkillLevelById(id: Long, nextLevel : Int)

    @Delete
    fun deleteUserSkill(skill : UserSkillEntity)
}