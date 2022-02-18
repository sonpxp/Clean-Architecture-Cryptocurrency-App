package com.fictivestudios.cryptocurrencyapp.presentation.coin_list

import com.fictivestudios.cryptocurrencyapp.domain.model.Coin

data class  CoinListState(
    val isLoading:Boolean=false,
    val coins:List<Coin> = emptyList(),
    val error:String=""
) {
}