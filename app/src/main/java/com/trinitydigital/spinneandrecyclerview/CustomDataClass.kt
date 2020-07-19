package com.trinitydigital.spinneandrecyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CustomDataClass(
    val id: Int = 1,
    val title: String = "нет его"
) : Parcelable