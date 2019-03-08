package com.knight.impl

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.knight.mvp.IMvpView
import com.knight.mvp.IPresenter
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure

/**
 * description: ${TODO}
 * author: Knight
 * new date: 2019/3/8 on 13:29
 * e-mail: 37442216knight@gmail.com
 * update: 2019/3/8 on 13:29
 * version: v 1.0
 */
open class BaseFragment<out P : BasePresenter<BaseFragment<P>>> : IMvpView<P>, Fragment() {

    override val presenter: P

    init {
        presenter = createPresenterKt()
        presenter.view = this

    }

    fun createPresenterKt(): P {
        sequence {
            var thisClass: KClass<*> = this@BaseFragment::class
            while (true) {
                yield(thisClass.supertypes)
                thisClass = thisClass.supertypes.firstOrNull()?.jvmErasure ?: break
            }
        }.flatMap {
            it.flatMap { it.arguments }.asSequence()
        }.first {
            it.type?.jvmErasure?.isSubclassOf(IPresenter::class) ?: false
        }.let {
            return it.type!!.jvmErasure.primaryConstructor!!.call() as P
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        presenter.onViewStateRestored(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    class MainFragment : BaseFragment<MainPersenter>()
    class MainPersenter : BasePresenter<MainFragment>(){
        override fun onResume() {
            super.onResume()
            Log.d("mvp","MainPersenter onResume")
        }
    }

}