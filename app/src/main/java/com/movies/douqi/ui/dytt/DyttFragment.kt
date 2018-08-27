package com.movies.douqi.ui.dytt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.movies.douqi.base.BaseFragment
import com.movies.douqi.databinding.FragmentDyttBinding
import com.movies.douqi.extensions.observeNotNull

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
class DyttFragment : BaseFragment() {

    lateinit var model: DyttViewModel

    lateinit var binding: FragmentDyttBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this, factory).get(DyttViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        model.data.observeNotNull(this) {
            if (it.rows != null && it.rows!!.isNotEmpty()) {
                binding.recycler.adapter = DyttAdapter(it.rows!!)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDyttBinding.inflate(inflater, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.apply {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        model.getMovieList()
    }

}