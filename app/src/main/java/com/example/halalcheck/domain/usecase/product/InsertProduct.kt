package com.example.halalcheck.domain.usecase.product

import com.example.halalcheck.data.local.entity.ProductEntity
import com.example.halalcheck.data.repository.ProductRepository
import javax.inject.Inject

class InsertProduct @Inject constructor(
    private val repository: ProductRepository
){
    suspend operator fun invoke(product: ProductEntity){
        repository.insertProduct(product)
    }
}