package mx.com.develop.iu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import mx.com.develop.R
import mx.com.develop.databinding.ActivityRandomBinding
import mx.com.develop.viewmodel.QuoteViewModel

class RandomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRandomBinding
    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()
        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })
        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}