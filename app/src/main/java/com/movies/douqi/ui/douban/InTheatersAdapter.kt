package com.movies.douqi.ui.douban

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.doOnLayout
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.movies.data.resultentities.InTheaterEntryWithFilm
import com.movies.douqi.R
import com.movies.douqi.utils.GlideApp

/**
 * @author donnieSky
 * @created_at 2018/9/6.
 * @description
 * @version
 */
class InTheatersAdapter() : PagedListAdapter<InTheaterEntryWithFilm, RecyclerView.ViewHolder>(FILM_COMPARATOR) {

    var intheaters: List<InTheaterEntryWithFilm> = emptyList()

    override fun getItemCount(): Int {
        return intheaters.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_douban_item, parent, false)
        return DoubanViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val intheater = intheaters[position]
        if (holder is DoubanViewHolder) {
            GlideApp.with(holder.image).clear(holder.image)

            if (intheater.film.images != null) {
                holder.image.doOnLayout {
                    GlideApp.with(holder.image)
                            .saturateOnLoad()
                            .load(intheater.film.images)
                            .centerCrop()
                            .into(holder.image)
                }
            }
        }
    }

    inner class DoubanViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val image: ImageView = itemview.findViewById(R.id.image)
    }

    companion object {
        private val PAYLOAD_SCORE = Any()
        val FILM_COMPARATOR = object : DiffUtil.ItemCallback<InTheaterEntryWithFilm>() {
            override fun areContentsTheSame(oldItem: InTheaterEntryWithFilm, newItem: InTheaterEntryWithFilm): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: InTheaterEntryWithFilm, newItem: InTheaterEntryWithFilm): Boolean {
                return oldItem.film == newItem.film
            }

            override fun getChangePayload(oldItem: InTheaterEntryWithFilm, newItem: InTheaterEntryWithFilm): Any? {
                return super.getChangePayload(oldItem, newItem)
            }
        }
    }

}