package com.e.study220924.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    val id : Long,

    @ColumnInfo(name = "email", typeAffinity = ColumnInfo.TEXT)
    var email : Long,

    @ColumnInfo(name = "password", typeAffinity = ColumnInfo.TEXT)
    var password : String,

    @ColumnInfo(name = "level", typeAffinity = ColumnInfo.INTEGER)
    var level : Int,

    @ColumnInfo(name = "nickName", typeAffinity = ColumnInfo.TEXT)
    var nickName : String,

    @ColumnInfo(name = "profileImage", typeAffinity = ColumnInfo.BLOB)
    var profileImage : ByteArray?,

    @ColumnInfo(name = "syncDate", typeAffinity = ColumnInfo.TEXT)
    var syncDate : String
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserEntity

        if (id != other.id) return false
        if (email != other.email) return false
        if (password != other.password) return false
        if (level != other.level) return false
        if (nickName != other.nickName) return false
        if (profileImage != null) {
            if (other.profileImage == null) return false
            if (!profileImage.contentEquals(other.profileImage)) return false
        } else if (other.profileImage != null) return false
        if (syncDate != other.syncDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + level
        result = 31 * result + nickName.hashCode()
        result = 31 * result + (profileImage?.contentHashCode() ?: 0)
        result = 31 * result + syncDate.hashCode()
        return result
    }


}
