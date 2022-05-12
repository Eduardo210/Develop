package mx.com.develop.domain

import mx.com.develop.data.QuoteRepository
import mx.com.develop.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}