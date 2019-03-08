package com.knight.impl

import android.content.res.Configuration
import android.os.Bundle
import com.knight.mvp.IMvpView
import com.knight.mvp.IPresenter

/**
 * description: ${TODO}
 * author: Knight
 * new date: 2019/3/8 on 11:19
 * e-mail: 37442216knight@gmail.com
 * update: 2019/3/8 on 11:19
 * version: v 1.0
 */
abstract class BasePresenter<out V : IMvpView<BasePresenter<V>>> : IPresenter<V> {


    override lateinit var view: @UnsafeVariance V

    override fun onConfigurationChanged(newConfig: Configuration) = Unit

    override fun onCreate(savedInstanceState: Bundle?) = Unit

    override fun onViewStateRestored(savedInstanceState: Bundle?) = Unit

    override fun onStart() = Unit

    override fun onResume() = Unit

    override fun onPause() = Unit

    override fun onSaveInstanceState(outState: Bundle) = Unit

    override fun onStop() = Unit

    override fun onDestroy() = Unit

}