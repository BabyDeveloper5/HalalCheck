package com.example.halalcheck.domain.usecase.product

import com.example.halalcheck.data.local.entity.ProductEntity
import com.example.halalcheck.data.repository.ProductRepository
import javax.inject.Inject

class DeleteProduct @Inject constructor(
    private val repository: ProductRepository
){
    suspend operator fun invoke(product: ProductEntity){
        repository.deleteProduct(product)
    }
}