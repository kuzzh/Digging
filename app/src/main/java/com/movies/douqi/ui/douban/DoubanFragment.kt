package com.movies.douqi.ui.douban

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.movies.douqi.base.BaseFragment
import com.movies.douqi.databinding.FragmentDoubanBinding
import com.movies.douqi.extensions.observeNotNull

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
class DoubanFragment : BaseFragment() {

    lateinit var model: DoubanViewModel

    lateinit var binding: FragmentDoubanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this, factory).get(DoubanViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        model.data.observeNotNull(this) { result ->
            if (result.subjects != null && result.subjects!!.isNotEmpty()) {
                binding.recycler.adapter = DoubanAdapter(result.subjects!!)
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

        model.inTheaters()
    }

}