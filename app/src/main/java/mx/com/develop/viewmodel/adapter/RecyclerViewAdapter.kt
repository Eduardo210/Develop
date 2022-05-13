package mx.com.develop.viewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import mx.com.develop.R
import mx.com.develop.model.QuoteModel

class RecyclerViewAdapter constructor(private val textos: List<QuoteModel>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var clickListener: ClickListener<QuoteModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.reciclerview_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = textos[position]
        holder.quoter.text = movie.quote
        holder.author.text = "Rating : ${movie.author}"
    }

    override fun getItemCount(): Int {
        return textos.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val quoter: TextView = itemView.findViewById(R.id.txtQuoter)
        val author: TextView = itemView.findViewById(R.id.txtAuthor)
        val cardView: CardView = itemView.findViewById(R.id.carView)

    }

    interface ClickListener<T> {
        fun onItemClick(data: T)
    }
}


