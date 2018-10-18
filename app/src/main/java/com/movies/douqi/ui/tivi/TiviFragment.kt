package com.movies.douqi.ui.tivi

import android.os.AsyncTask
import android.os.Bundle
import android.util.JsonReader
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.exoplayer2.ParserException
import com.movies.data.entities.Tivi
import com.movies.douqi.R
import com.movies.douqi.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_douban.*
import java.io.IOException
import java.io.InputStreamReader

/**
 * @author donnieSky
 * @created_at 2018/10/18.
 * @description
 * @version
 */
class TiviFragment : BaseFragment() {

    private val controller = TiviController()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_douban, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.apply {
            itemAnimator = null
            layoutManager = GridLayoutManager(activity, 2)
            setController(controller)
        }
        if (savedInstanceState == null) {
            controller.callbacks = object : TiviController.Callbacks {
                override fun onItemClicked(item: Tivi) {
                    startActivity(TiviPlayerActivity.startIntent(activity!!, item.name, item.url))
                }
            }

            val task = TiviTask()
            task.execute()
        }
    }

    @Throws(IOException::class)
    private fun readChannels(reader: JsonReader, channels: MutableList<Tivi>) {
        reader.beginObject()
        while (reader.hasNext()) {
            val nextName = reader.nextName()
            when (nextName) {
                "uuid" -> {
                    reader.nextString()
                }
                "title" -> {
                    reader.nextString()
                }
                "channels" -> {
                    reader.beginArray()
                    while (reader.hasNext()) {
                        readChannel(reader, channels)
                    }
                    reader.endArray()
                }
                else -> {
                    throw ParserException("Unsupported name: $nextName")
                }
            }
        }
        reader.endObject()
    }

    @Throws(IOException::class)
    private fun readChannel(reader: JsonReader, channels: MutableList<Tivi>) {
        var name = ""
        var url = ""
        reader.beginObject()
        while (reader.hasNext()) {
            val nextName = reader.nextName()
            when (nextName) {
                "name" -> {
                    name = reader.nextString()
                }
                "url" -> {
                    url = reader.nextString()
                }
                else -> {
                    throw ParserException("Unsupported name: $nextName")
                }
            }
        }
        reader.endObject()
        val tivi = Tivi(name, url)
        channels.add(tivi)
    }

    inner class TiviTask : AsyncTask<Void, Void, List<Tivi>>() {

        override fun doInBackground(vararg params: Void?): List<Tivi> {
            val result = mutableListOf<Tivi>()
            try {
                val inputStream = activity?.assets?.open("channels.json")
                readChannels(JsonReader(InputStreamReader(inputStream, "UTF-8")), result)
            } catch (e: Exception) {
                logger.e(e)
            } finally {

            }
            return result
        }

        override fun onPostExecute(result: List<Tivi>?) {
            if (result != null && result.isNotEmpty()) {
                controller.setData(result)
            }
        }
    }
}