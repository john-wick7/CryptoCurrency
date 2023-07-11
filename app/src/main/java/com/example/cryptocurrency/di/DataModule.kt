package com.example.cryptocurrency.di


import android.app.Application
import com.example.cryptocurrency.data.database.AppDatabase
import com.example.cryptocurrency.data.database.CoinInfoDao
import com.example.cryptocurrency.data.network.ApiFactory
import com.example.cryptocurrency.data.network.ApiService
import com.example.cryptocurrency.data.repository.CoinRepositoryImpl
import com.example.cryptocurrency.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}
