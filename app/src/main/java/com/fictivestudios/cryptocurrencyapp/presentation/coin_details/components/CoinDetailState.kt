package com.fictivestudios.cryptocurrencyapp.presentation.coin_details.components

import com.fictivestudios.cryptocurrencyapp.domain.model.Coin
import com.fictivestudios.cryptocurrencyapp.domain.model.CoinDetail

data class  CoinDetailState(
    val isLoading:Boolean=false,
    val coins:CoinDetail? = null,
    val error:String=""
) {
}