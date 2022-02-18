package com.fictivestudios.cryptocurrencyapp.data.remote

import com.fictivestudios.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.fictivestudios.cryptocurrencyapp.data.remote.dto.CoinDto
import com.fictivestudios.cryptocurrencyapp.domain.model.Coin
import com.fictivestudios.cryptocurrencyapp.domain.model.CoinDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins():List<CoinDto>


    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId:String):CoinDetailDto

}