package com.movies.douban.intheaters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.movies.core.base.BaseDaggerFragment
import com.movies.core.extensions.observeNotNull
import com.movies.core.widgets.SpacingItemDecorator
import com.movies.douban.R
import kotlinx.android.synthetic.main.fragment_rv_grid.*

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
class IntheatersFragment : BaseDaggerFragment() {

    private lateinit var model: IntheatersViewModel

    private val controller = IntheatersController()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_rv_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        model = ViewModelProviders.of(this, factory).get(IntheatersViewModel::class.java)

        recycler.apply {
            itemAnimator = null
            setController(controller)
            addItemDecoration(SpacingItemDecorator(paddingLeft))
        }

        swipe.setOnRefreshListener(model::refresh)

        model.dataSource.observeNotNull(this) {
            controller.submitList(it)
        }
    }

}