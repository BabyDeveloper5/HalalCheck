package com.example.halalcheck.di

import com.example.halalcheck.domain.usecase.product.*
import com.example.halalcheck.data.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductUseCaseModule {

    @Provides
    @Singleton
    fun provideProductUseCases(
        repository: ProductRepository
    ): ProductUseCases {
        return ProductUseCases(
            insertProduct = InsertProductUseCase(repository),
            deleteProduct = DeleteProductUseCase(repository),
            getAllProducts = GetAllProductsUseCase(repository),
            getProductByBarcode = GetProductByBarcodeUseCase(repository)
        )
    }
}