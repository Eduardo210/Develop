package mx.com.develop.model

import com.google.gson.annotations.SerializedName

//class QuoteModel (val quote: String, val author: String)
data class QuoteModel(
    @SerializedName("quote") val quote : String,
    @SerializedName("author") val author: String
)