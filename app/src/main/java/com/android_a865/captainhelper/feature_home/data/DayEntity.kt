package com.android_a865.captainhelper.feature_home.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Days")
data class DayEntity(
    @PrimaryKey
    val date: String,
    val day: Int,
    val month: String,
    val km: Int,
    val made: Int,
    val profits: Double,
    val done: Boolean
) : Parcelable