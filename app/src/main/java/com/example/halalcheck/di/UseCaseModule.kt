package com.example.halalcheck.di

import com.example.halalcheck.data.repository.ProductRepository
import com.example.halalcheck.domain.usecase.product.DeleteProduct
import com.example.halalcheck.domain.usecase.product.GetAllProducts
import com.example.halalcheck.domain.usecase.product.GetProductByBarcode
import com.example.halalcheck.domain.usecase.product.InsertProduct
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
            insertProduct = InsertProduct(repository),
            deleteProduct = DeleteProduct(repository),
            getAllProducts = GetAllProducts(repository),
            getProductByBarcode = GetProductByBarcode(repository)
        )
    }
}