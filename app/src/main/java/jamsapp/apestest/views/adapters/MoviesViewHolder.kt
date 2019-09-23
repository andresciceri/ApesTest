package jamsapp.apestest.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jamsapp.apestest.ApesTestApplication
import jamsapp.apestest.R
import jamsapp.apestest.data.models.Results

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_movies, parent, false)) {

    var context: Context? = null
    var movieIcon: ImageView? = null
    var descripTxt: TextView? = null
    var titleTxt: TextView? = null

    init {
        context = parent.context
        movieIcon = itemView.findViewById(R.id.iconIv)
        descripTxt = itemView.findViewById(R.id.subtitle_txt)
        titleTxt = itemView.findViewById(R.id.title_txt)
    }

    fun bind(results: Results) {
        Picasso.with(context)
            .load(results.image?.small_url)
            .resize(203, 300)
            .into(movieIcon)
        titleTxt?.text = results.name
        descripTxt?.text = results.description
    }
}