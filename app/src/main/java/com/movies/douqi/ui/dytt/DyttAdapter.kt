package com.movies.douqi.ui.dytt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.movies.douqi.R
import com.movies.dytt.entities.Movie

/**
 * @author donnieSky
 * @created_at 2018/8/27.
 * @description
 * @version
 */
class DyttAdapter(val movies: List<Movie>) : RecyclerView.Adapter<DyttAdapter.DyttViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DyttViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.list_dytt_item,
                parent,
                false
        )
        return DyttViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: DyttViewHolder, position: Int) {
        holder.text.text = movies[position].name
    }


    inner class DyttViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text: TextView = itemView.findViewById(R.id.sourceName)

    }
}