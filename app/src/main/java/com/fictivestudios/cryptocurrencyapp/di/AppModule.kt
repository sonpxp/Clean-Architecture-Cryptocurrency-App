package com.fictivestudios.cryptocurrencyapp.di

import com.fictivestudios.cryptocurrencyapp.common.Constants
import com.fictivestudios.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.fictivestudios.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.fictivestudios.cryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaparikaApi():CoinPaprikaApi
    {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)

    }

    @Provides
    @Singleton
    fun providesCoinRepository(api: CoinPaprikaApi):CoinRepository{
        return CoinRepositoryImpl(api)
    }

}