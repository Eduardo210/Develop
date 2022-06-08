package mx.com.develop.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.com.develop.domain.GetQuotesUseCase
import mx.com.develop.model.QuoteModel
import mx.com.develop.model.QuoteProvider

class QuoteViewModel : ViewModel() {

    var getQuotesUseCase = GetQuotesUseCase()

    val quoteModel = MutableLiveData<QuoteModel>()

    fun onCreate() {
        viewModelScope.launch {
            val result = getQuotesUseCase()
            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                Log.d("Result", result.toString())
            }
        }
    }

    fun randomQuote(){
        val currentQuote = QuoteProvider.quotes.random()
        quoteModel.postValue(currentQuote)
    }
}