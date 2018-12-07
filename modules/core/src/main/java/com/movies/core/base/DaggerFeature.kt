package com.movies.core.base

import android.app.Service
import android.content.BroadcastReceiver
import android.content.ContentProvider
import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.*
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/12/7.
 * @description
 * @version
 */
abstract class DaggerFeature : Fragment(),
        HasSupportFragmentInjector,
        HasServiceInjector,
        HasBroadcastReceiverInjector,
        HasContentProviderInjector {

    @Inject
    lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var broadcastReceiverInjector: DispatchingAndroidInjector<BroadcastReceiver>

    @Inject
    lateinit var serviceInjector: DispatchingAndroidInjector<Service>
    @Inject
    lateinit var contentProviderInjector: DispatchingAndroidInjector<ContentProvider>

    @Volatile
    private var needToInject = true

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        injectIfNecessary()
    }

    protected abstract fun featureInjector(): AndroidInjector<out DaggerFeature>

    private fun injectIfNecessary() {
        if (needToInject) {
            synchronized(this) {
                if (needToInject) {
                    @SuppressWarnings("unchecked")
                    val featureInjector = (featureInjector() as AndroidInjector<DaggerFeature>)
                    featureInjector.inject(this)
                    if (needToInject) {
                        throw IllegalStateException(
                                "The AndroidInjector returned from featureInjector() did not inject the " + "DaggerFeature")
                    }
                }
            }
        }
    }

    @Inject
    fun setInjected() {
        needToInject = false
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return supportFragmentInjector
    }

    override fun broadcastReceiverInjector(): AndroidInjector<BroadcastReceiver> {
        return broadcastReceiverInjector
    }

    override fun serviceInjector(): AndroidInjector<Service> {
        return serviceInjector
    }

    override fun contentProviderInjector(): AndroidInjector<ContentProvider> {
        return contentProviderInjector
    }
}