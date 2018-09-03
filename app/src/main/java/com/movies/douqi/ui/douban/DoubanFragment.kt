package com.movies.douqi.ui.douban

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.movies.douban.entities.Subject
import com.movies.douqi.base.BaseFragment
import com.movies.douqi.databinding.FragmentDoubanBinding
import com.movies.douqi.extensions.observeNotNull
import com.movies.douqi.ui.detail.MovieDetailActivity

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
class DoubanFragment : BaseFragment() {

    lateinit var model: DoubanViewModel

    lateinit var binding: FragmentDoubanBinding

    private val adapter = DoubanAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this, factory).get(DoubanViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        model.data.observeNotNull(this) { result ->
            if (result.subjects != null && result.subjects!!.isNotEmpty()) {
                binding.swipe.isRefreshing = false
                adapter.subjects = result.subjects!!
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDoubanBinding.inflate(inflater, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.onDoubanItemClickListener = object : DoubanAdapter.onItemClickListener {
            override fun onClick(subject: Subject?) {
                if (subject != null) {
                    startActivity(MovieDetailActivity.startIntent(context!!, subject.title))
                }
            }
        }
        binding.recycler.layoutManager = GridLayoutManager(context, 3)
        binding.recycler.adapter = adapter

        binding.swipe.setOnRefreshListener {
            model.inTheaters()
        }

        model.inTheaters()

    }

}