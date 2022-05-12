package mx.com.develop.iu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import mx.com.develop.databinding.ActivityMainBinding
import mx.com.develop.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding
    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()
        binding.btnList.setOnClickListener(this)
        binding.btnCard.setOnClickListener(this)
        binding.btnRandom.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            binding.btnList.id ->{
                val intent = Intent(this, ListViewActivity::class.java)
                startActivity(intent)
            }
            binding.btnCard.id -> {
                val intent = Intent(this, CardViewActivity::class.java)
                startActivity(intent)
            }
            binding.btnRandom.id ->{
                val intent = Intent(this, RandomActivity::class.java)
                startActivity(intent)
            }
        }
    }
}