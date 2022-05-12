package mx.com.develop.data

import mx.com.develop.data.network.QuoteService
import mx.com.develop.model.QuoteModel
import mx.com.develop.model.QuoteProvider

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}