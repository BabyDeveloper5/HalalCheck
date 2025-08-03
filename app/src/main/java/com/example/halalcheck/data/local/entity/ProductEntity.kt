package com.example.halalcheck.data.local.entity

import android.text.BoringLayout
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey()
    val barcode: String,
    val name: String,
    val ingredients: String,    // JSON or comma-separated list
    val isHalal: Boolean
)
