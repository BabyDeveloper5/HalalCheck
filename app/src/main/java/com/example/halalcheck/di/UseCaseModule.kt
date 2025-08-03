package com.example.halalcheck.di

import com.example.halalcheck.data.repository.ProductRepository
import com.example.halalcheck.domain.usecase.product.DeleteProductUseCase
import com.example.halalcheck.domain.usecase.product.GetAllProductsUseCase
import com.example.halalcheck.domain.usecase.product.GetProductByBarcodeUseCase
import com.example.halalcheck.domain.usecase.product.InsertProductUseCase
import com.example.halalcheck.domain.usecase.product.ProductUseCases
import com.google.android.datatransport.runtime.dagger.Provides
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule{
    @Provides
    @Singleton
    fun provideProductUseCase(
        repository: ProductRepository
    ): ProductUseCases{
        return ProductUseCases(
            insertProduct = InsertProductUseCase(repository),
            deleteProduct = DeleteProductUseCase(repository),
            getAllProducts = GetAllProductsUseCase(repository),
            getProductByBarcode = GetProductByBarcodeUseCase(repository)
        )
    }
}