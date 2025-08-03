package com.example.halalcheck.domain.usecase.product

import com.example.halalcheck.data.local.entity.ProductEntity
import com.example.halalcheck.data.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductByBarcodeUseCase @Inject constructor(
    private val repository: ProductRepository
){
    suspend operator fun invoke(barcode: String): Flow<ProductEntity?> {
        return repository.getProductByBarcode(barcode)
    }
}