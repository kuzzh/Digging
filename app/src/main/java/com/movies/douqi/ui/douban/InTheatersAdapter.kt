package com.movies.douqi.ui.douban

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.movies.data.resultentities.InTheaterEntryWithFilm
import com.movies.douqi.BR
import com.movies.douqi.databinding.ListDoubanItemBinding

/**
 * @author donnieSky
 * @created_at 2018/9/6.
 * @description
 * @version
 */
class InTheatersAdapter : PagedListAdapter<InTheaterEntryWithFilm, RecyclerView.ViewHolder>(FILM_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListDoubanItemBinding.inflate(inflater, parent, false)
        return DoubanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is DoubanViewHolder) {
            holder.bind(getItem(position))
        }
    }

    inner class DoubanViewHolder(
            private val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(o: Any?) {
            binding.setVariable(BR.film, o)
            binding.executePendingBindings()
        }
    }

    companion object {
        val FILM_COMPARATOR = object : DiffUtil.ItemCallback<InTheaterEntryWithFilm>() {
            override fun areContentsTheSame(oldItem: InTheaterEntryWithFilm, newItem: InTheaterEntryWithFilm): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: InTheaterEntryWithFilm, newItem: InTheaterEntryWithFilm): Boolean {
                return oldItem.film.id == newItem.film.id
            }
        }
    }

}