package com.movies.douqi.widget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.movies.data.Entry
import com.movies.data.resultentities.EntryWithFilm
import com.movies.douqi.R
import com.movies.douqi.base.BaseFragment
import com.movies.douqi.extensions.observeByNull
import com.movies.douqi.utils.EntryGridEpoxyController
import com.movies.douqi.utils.EntryViewModel
import com.movies.douqi.utils.Status
import kotlinx.android.synthetic.main.fragment_douban.*

/**
 * @author donnieSky
 * @created_at 2018/9/10.
 * @description
 * @version
 */
abstract class EntryGridFragment<LI : EntryWithFilm<out Entry>, VM : EntryViewModel<LI>>(
        private val vmClass: Class<VM>
) : BaseFragment() {

    protected lateinit var model: VM

    private lateinit var controller: EntryGridEpoxyController<LI>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this, factory).get(vmClass)
        controller = createController()
        controller.callbacks = object : EntryGridEpoxyController.Callbacks<LI> {
            override fun onItemClicked(item: LI) {
                this@EntryGridFragment.onItemClicked(item)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_douban, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.apply {
            itemAnimator = null
            setController(controller)
            addItemDecoration(SpacingItemDecoration(paddingLeft))
        }

        swipe.setOnRefreshListener(model::refresh)

        model.liveList.observeByNull(this) {
            controller.setList(it)
        }

        model.viewState.observeByNull(this) { res ->
            res?.let {
                when (it.status) {
                    Status.SUCCESS -> {
                        swipe.isRefreshing = false
                        controller.isLoading = false
                    }
                    Status.ERROR -> {
                        swipe.isRefreshing = false
                        controller.isLoading = false
                        Snackbar.make(recycler, it.message ?: "EMPTY", Snackbar.LENGTH_SHORT).show()
                    }
                    Status.REFRESHING -> {
                        swipe.isRefreshing = true
                    }
                    Status.LOADING_MORE -> {
                        controller.isLoading = true
                    }
                }
            }
        }
    }

    abstract fun onItemClicked(item: LI)

    open fun createController(): EntryGridEpoxyController<LI> {
        return EntryGridEpoxyController()
    }
}