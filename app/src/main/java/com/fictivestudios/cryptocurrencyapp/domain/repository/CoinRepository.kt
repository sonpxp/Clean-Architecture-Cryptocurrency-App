package com.fictivestudios.cryptocurrencyapp.domain.repository

import com.fictivestudios.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.fictivestudios.cryptocurrencyapp.data.remote.dto.CoinDto
import com.fictivestudios.cryptocurrencyapp.domain.model.Coin

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto

}