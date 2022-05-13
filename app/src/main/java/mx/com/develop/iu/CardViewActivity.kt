package mx.com.develop.iu

import android.app.PendingIntent.getActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import mx.com.develop.R
import mx.com.develop.databinding.ActivityCardViewBinding
import mx.com.develop.model.QuoteModel
import mx.com.develop.viewmodel.adapter.RecyclerViewAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import mx.com.develop.model.QuoteProvider
import mx.com.develop.viewmodel.QuoteViewModel


class CardViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCardViewBinding

    private var recyclerView: RecyclerView? = null
    private var recyclerViewAdapter: RecyclerViewAdapter? = null
    private var movieList = mutableListOf<QuoteModel>()

    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        movieList = ArrayList()
        recyclerView = binding.recyclerView as RecyclerView
        recyclerViewAdapter = RecyclerViewAdapter(QuoteProvider.quotes)

//        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
//        recyclerView!!.layoutManager = layoutManager
//
        val mLayoutManager = GridLayoutManager(this, 2)
        recyclerView!!.layoutManager = mLayoutManager

        recyclerView!!.adapter = recyclerViewAdapter


    }


}