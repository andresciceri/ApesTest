package jamsapp.apestest.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jamsapp.apestest.data.models.Results

class MoviesAdapter(private val list: List<Results>?) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val result: Results? = list?.get(position)
        result?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = list!!.size
}