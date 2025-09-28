package com.example.halalcheck.domain.usecase.product

import javax.inject.Inject

// Combining use cases into a wrapper class makes it easy
// to inject all use cases together in a ViewModel.
data class ProductUseCases @Inject constructor(
    val insertProduct: InsertProductUseCase,
    val deleteProduct: DeleteProductUseCase,
    val getAllProducts: GetAllProductsUseCase,
    val getProductByBarcode: GetProductByBarcodeUseCase
)
