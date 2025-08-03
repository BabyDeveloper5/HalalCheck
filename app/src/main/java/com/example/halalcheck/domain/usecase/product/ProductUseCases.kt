package com.example.halalcheck.domain.usecase.product

// Combining use cases into a wrapper class makes it easy
// to inject all use cases together in a ViewModel.
data class ProductUseCases(
    val insertProduct: InsertProduct,
    val deleteProduct: DeleteProduct,
    val getAllProducts: GetAllProducts,
    val getProductByBarcode: GetProductByBarcode
)
