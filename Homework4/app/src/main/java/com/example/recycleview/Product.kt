package com.example.recycleview

import androidx.annotation.DrawableRes

data class Product(
    val id: Int,
    val title: String,
    val price: String,
    @DrawableRes
    val image: Int

) {
    fun getInfo() : String {
        return "$title - $price"
    }
}