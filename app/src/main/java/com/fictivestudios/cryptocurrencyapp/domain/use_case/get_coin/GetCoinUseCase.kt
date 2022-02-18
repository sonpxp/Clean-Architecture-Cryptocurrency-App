package com.fictivestudios.cryptocurrencyapp.domain.use_case.get_coin

import com.fictivestudios.cryptocurrencyapp.common.Resource
import com.fictivestudios.cryptocurrencyapp.data.remote.dto.toCoin
import com.fictivestudios.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.fictivestudios.cryptocurrencyapp.domain.model.Coin
import com.fictivestudios.cryptocurrencyapp.domain.model.CoinDetail
import com.fictivestudios.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow{
        try {

            emit(Resource.Loading())
            val coin=repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }
        catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?:"An unExpected Error occured"))
        }
        catch (e: IOException){
            emit(Resource.Error(e.localizedMessage?:"Could't reach server:Please Check Your Internet connection"))
        }
    }


}