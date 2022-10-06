package com.e.study220924.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "skills",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class, parentColumns = arrayOf("id"),
        childColumns = arrayOf("userId"), onDelete = ForeignKey.CASCADE
    )]
)
data class UserSkillEntity(
    @PrimaryKey
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    var id: Long,

    @ColumnInfo(name = "userId", typeAffinity = ColumnInfo.INTEGER)
    val userId: Long,

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    var name: String,

    @ColumnInfo(name = "level", typeAffinity = ColumnInfo.INTEGER)
    var level: Int
)
