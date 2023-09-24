package com.android_a865.captainhelper.feature_home.data

import com.android_a865.captainhelper.utils.getDate
import com.android_a865.captainhelper.utils.getDay
import java.text.SimpleDateFormat
import java.util.Locale

class DaysRepository(
    private val dao: DayDao
) {

    fun getDays() = dao.getDays()

    suspend fun insertDay(km: Int, made: Int, done: Boolean) {

        val time = System.currentTimeMillis()
        val day = time.getDay()
        val month = time.getDate()
        val date = "$day/$month"

        val kmCoast = 10

        val profits = (made * 0.9) - (km * kmCoast)

        dao.insertDay(
            DayEntity(
                day = day,
                date = date,
                month = month,
                made = made,
                profits = profits,
                km = km,
                done = done
            )
        )
    }
}