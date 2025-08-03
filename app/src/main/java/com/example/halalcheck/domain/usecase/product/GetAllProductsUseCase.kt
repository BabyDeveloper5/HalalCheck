package com.example.halalcheck.domain.usecase.product

import com.example.halalcheck.data.local.entity.ProductEntity
import com.example.halalcheck.data.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val repository: ProductRepository
){
    operator fun invoke(): Flow<List<ProductEntity>>{
        return repository.getAllProducts()
    }
}