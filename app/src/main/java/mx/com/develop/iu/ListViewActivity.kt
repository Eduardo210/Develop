package mx.com.develop.iu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import mx.com.develop.databinding.ActivityListViewBinding
import mx.com.develop.domain.GetQuotesUseCase
import mx.com.develop.model.QuoteModel
import mx.com.develop.model.QuoteProvider
import mx.com.develop.viewmodel.QuoteViewModel
import mx.com.develop.viewmodel.adapter.AdapterListView

class ListViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListViewBinding
    private lateinit var listview : ListView
    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var quote : ArrayList<String> = ArrayList<String>()
        val author : ArrayList<String> = ArrayList<String>()

        quoteViewModel.onCreate()

        QuoteProvider.quotes.forEach { i ->
            quote.add(i.quote)
            author.add(i.author)
        }

        val myListAdapter = AdapterListView(this,quote,author)
            binding.recipeListView.adapter = myListAdapter
    }
}