package com.movies.douqi.ui.douban

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.movies.douban.entities.Subject
import com.movies.douqi.BR
import com.movies.douqi.databinding.ListDoubanItemBinding

/**
 * @author donnieSky
 * @created_at 2018/8/31.
 * @description
 * @version
 */
class DoubanAdapter(val subjects: List<Subject>) : RecyclerView.Adapter<DoubanAdapter.DoubanViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoubanViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListDoubanItemBinding.inflate(inflater, parent, false)
        return DoubanViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return subjects.size
    }

    override fun onBindViewHolder(holder: DoubanViewHolder, position: Int) {
        holder.bind(subjects[position])
    }

    inner class DoubanViewHolder(
            private val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(o: Any?) {
            binding.setVariable(BR.subject, o)
            binding.executePendingBindings()
        }

    }

}