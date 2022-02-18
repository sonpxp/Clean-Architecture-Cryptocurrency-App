package com.fictivestudios.cryptocurrencyapp.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fictivestudios.cryptocurrencyapp.presentation.Screen
import com.fictivestudios.cryptocurrencyapp.presentation.coin_details.components.CoinDetailScreen
import com.fictivestudios.cryptocurrencyapp.presentation.coin_list.components.CoinListScreen
import com.fictivestudios.cryptocurrencyapp.presentation.ui.theme.CryptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListscreen.route
                    ) {
                        composable(
                            route = Screen.CoinListscreen.route
                        ) {

                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailscreen.route + "/{coinId}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
