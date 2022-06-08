package mx.com.develop.iu

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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

        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        if (isConnected){
            quoteViewModel.onCreate()
        }else{
            Toast.makeText(this, "Verifica tu conexión a internet", Toast.LENGTH_SHORT).show()
            binding.btnCard.isEnabled = false
            binding.btnList.isEnabled = false
            binding.btnRandom.isEnabled = false
        }
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