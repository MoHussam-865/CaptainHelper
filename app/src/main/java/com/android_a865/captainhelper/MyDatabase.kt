package com.android_a865.captainhelper

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android_a865.captainhelper.MyDatabase.Companion.DATABASE_VERSION
import com.android_a865.captainhelper.feature_home.data.DayDao
import com.android_a865.captainhelper.feature_home.data.DayEntity

@Database(
    entities = [
        DayEntity::class
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)

abstract class MyDatabase: RoomDatabase() {

    abstract fun getDays(): DayDao

    companion object {
        // Room Database
        const val DATABASE_NAME = "CaptainHelper.db"
        const val DATABASE_VERSION = 1
    }
}