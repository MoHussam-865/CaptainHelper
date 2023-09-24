package com.android_a865.captainhelper.utils

import java.text.SimpleDateFormat
import java.util.Locale

val <T> T.exhaustive: T get() = this


fun Long.getDay() : Int {
    return SimpleDateFormat(
        "d",
        Locale.getDefault()
    ).format(this).toInt()
}

fun Long.getDate() : String {
    return SimpleDateFormat(
        "MM/yyyy",
        Locale.getDefault()
    ).format(this)
}