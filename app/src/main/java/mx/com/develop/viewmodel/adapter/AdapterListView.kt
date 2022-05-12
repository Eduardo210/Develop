package mx.com.develop.viewmodel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.com.develop.R

class AdapterListView(
    private val context: Context,
    private val QuoteList: ArrayList<String>,
    private val AuthorList: ArrayList<String>
) : BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return QuoteList.size
    }

    override fun getItem(position: Int): Any {
        return QuoteList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.list_item, parent, false)
        val txtQuote = rowView.findViewById<TextView>(R.id.txt_quote)
        val txtAuthor = rowView.findViewById<TextView>(R.id.txt_author)

        txtQuote.text =  QuoteList[position]
        txtAuthor.text = AuthorList[position]

        return rowView
    }
}