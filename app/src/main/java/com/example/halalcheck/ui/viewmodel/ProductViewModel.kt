package com.example.halalcheck.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.halalcheck.data.local.entity.ProductEntity
import com.example.halalcheck.domain.usecase.product.ProductUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productUseCases: ProductUseCases
): ViewModel() {
    val allProducts: StateFlow<List<ProductEntity>> =
        productUseCases.getAllProducts().stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    private val _scannedProduct = MutableStateFlow<ProductEntity?>(null)
    val scannedProduct: StateFlow<ProductEntity?> = _scannedProduct.asStateFlow()

    fun getProductByBarcode(barcode: String){
        viewModelScope.launch {
            productUseCases.getProductByBarcode(barcode).collect() {
                _scannedProduct.value = it
            }
        }
    }

    fun insertProduct(product: ProductEntity){
        viewModelScope.launch {
            Log.d("ProductViewModel", "Inserting product: $product")
            productUseCases.insertProduct(product)
        }
    }

    fun deleteProduct(product: ProductEntity){
        viewModelScope.launch {
            Log.d("ProductViewModel", "Deleting product: $product")
            productUseCases.deleteProduct(product)
        }
    }



}