package mx.com.develop.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.com.develop.core.ConnectionRetrofit
import mx.com.develop.model.QuoteModel

class QuoteService {

    private val retrofit = ConnectionRetrofit.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}