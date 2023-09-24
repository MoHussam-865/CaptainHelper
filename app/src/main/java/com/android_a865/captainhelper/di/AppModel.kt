package com.android_a865.captainhelper.di

import android.app.Application
import androidx.room.Room
import com.android_a865.captainhelper.MyDatabase
import com.android_a865.captainhelper.MyDatabase.Companion.DATABASE_NAME
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Singleton
@InstallIn(SingletonComponent::class)
object AppModel {

    @Provides
    @Singleton
    fun provideRoomDatabase(app: Application): MyDatabase =
        Room.databaseBuilder(app, MyDatabase::class.java, DATABASE_NAME)
            .build()

}