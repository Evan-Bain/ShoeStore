package com.udacity.shoestore

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var brand: String, var type: String, var sizeGroup: String, var size: String, var description: String) : Parcelable