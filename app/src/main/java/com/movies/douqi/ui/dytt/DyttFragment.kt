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
import com.movies.douqi.ui.mahua.MahuaViewModel

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
class DyttFragment : BaseFragment() {

    private lateinit var model: DyttViewModel

    private lateinit var mahuaModel: MahuaViewModel

    private lateinit var binding: FragmentDyttBinding

    private val title: String by lazy {
        arguments!!.getString(ARGS_MOVIE_TITLE)
    }

    companion object {
        private const val ARGS_MOVIE_TITLE = "ARGS_MOVIE_TITLE"
        fun newInstance(title: String): DyttFragment {
            val bundle = Bundle().apply {
                putString(ARGS_MOVIE_TITLE, title)
            }
            return DyttFragment().apply { arguments = bundle }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this, factory).get(DyttViewModel::class.java)
        mahuaModel = ViewModelProviders.of(this, factory).get(MahuaViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        model.data.observeNotNull(this) {
            if (it.rows != null && it.rows!!.isNotEmpty()) {
                binding.recycler.adapter = DyttAdapter(it.rows!!)
            }
        }

        model.mahuaData.observeNotNull(this) {
            if (it.success && it.data != null && it.data!!.isNotEmpty()) {
                binding.recycler.adapter = MahuaAdapter(it.data!!)
            }
        }

        mahuaModel.data.observeNotNull(this) {
            if (it.isNotEmpty()) {
                binding.recycler.adapter = MahuaAdapter(it)
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
        //model.searchVideo()

        // model.getMovieList(title)
        mahuaModel.search(title, 1)

    }

}