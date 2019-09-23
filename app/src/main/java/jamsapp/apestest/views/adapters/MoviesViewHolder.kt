package jamsapp.apestest.views.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jamsapp.apestest.R
import jamsapp.apestest.data.models.Results
import jamsapp.apestest.data.models.Studios
import jamsapp.apestest.data.models.Writers
import jamsapp.apestest.views.detail.DetailActivity

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
            .resize(270, 400)
            .into(movieIcon)

        titleTxt?.text = results.name

        if(results.description != null)
            descripTxt?.text = results.description
        else
            descripTxt?.visibility = View.GONE

        itemView.setOnClickListener {
            showMovieDetails(context, results)
        }
    }

    private fun showMovieDetails(context: Context?, results: Results){
        context?.startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra("banner", results.image?.screen_large_url)
                .putExtra("title", results.name)
                .putExtra("description", results.description)
                .putExtra("budget", results.budget)
                .putExtra("runtime", results.runtime)
                .putExtra("studios", getStudios(results.studios))
                .putExtra("writers", getWriters(results.writers))
        )
    }

    private fun getStudios(studios: List<Studios>?): String? {
        var s = ""

        val size = studios?.size
        if(size?.compareTo(1) == 0) {
            s = s.plus(studios[0].name)
        } else {
            var counter = Integer.parseInt("1")
            studios?.forEach {
                s = s.plus(it.name)
                if(counter != size)
                    s = s.plus(", ")
                counter++
            }
        }

        return s
    }

    private fun getWriters(writers: List<Writers>?): String? {
        var s = ""

        val size = writers?.size
        if(size?.compareTo(1) == 0) {
            s = s.plus(writers[0].name)
        } else {
            var counter = Integer.parseInt("1")
            writers?.forEach {
                s = s.plus(it.name)
                if(counter != size)
                    s = s.plus(", ")
                counter++
            }
        }

        return s
    }
}