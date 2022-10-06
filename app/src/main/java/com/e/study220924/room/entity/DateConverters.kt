package com.e.study220924.room.entity

import androidx.room.TypeConverter
import java.util.*

class DateConverters {
    @TypeConverter
    fun dateToString(date : Date?): String? {
        return date?.time?.toString()
    }

    @TypeConverter
    fun stringToDate(string: String): Date? {
        return string?.let { Date(it) }
    }
}