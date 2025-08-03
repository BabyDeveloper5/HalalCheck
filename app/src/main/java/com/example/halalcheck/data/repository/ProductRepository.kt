package com.example.halalcheck.data.repository

import com.example.halalcheck.data.local.dao.ProductDao
import com.example.halalcheck.data.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productDao: ProductDao
){
    suspend fun insertProduct(product: ProductEntity){
        productDao.insertProduct(product)
    }
    suspend fun deleteProduct(product: ProductEntity){
        productDao.deleteProduct(product)
    }
    fun getAllProducts(): Flow<List<ProductEntity>> {
        return productDao.getAllProducts()
    }

    fun getProductByBarcode(barcode: String): Flow<ProductEntity?> {
        return productDao.getProductByBarcode(barcode)
    }
}