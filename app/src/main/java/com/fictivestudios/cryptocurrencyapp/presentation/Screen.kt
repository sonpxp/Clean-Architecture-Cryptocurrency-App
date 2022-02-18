package com.fictivestudios.cryptocurrencyapp.presentation

sealed class Screen(val route:String){
    object CoinListscreen: Screen("coin_List")
    object CoinDetailscreen: Screen("coin_detail")
}