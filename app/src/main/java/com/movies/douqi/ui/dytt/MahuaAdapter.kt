package com.movies.douqi.ui.dytt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.movies.douqi.R
import com.movies.mahua.entities.Video

/**
 * @author donnieSky
 * @created_at 2018/9/12.
 * @description
 * @version
 */
class MahuaAdapter(val videos: List<Video>) : RecyclerView.Adapter<MahuaAdapter.MahuaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahuaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.list_dytt_item,
                parent,
                false
        )
        return MahuaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return videos.size
    }

    override fun onBindViewHolder(holder: MahuaAdapter.MahuaViewHolder, position: Int) {
        holder.text.text = videos[position].title
    }


    inner class MahuaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text: TextView = itemView.findViewById(R.id.sourceName)

    }
}