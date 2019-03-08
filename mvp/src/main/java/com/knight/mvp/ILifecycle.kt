package com.knight.mvp

import android.content.res.Configuration
import android.os.Bundle

/**
 * description: ${TODO}
 * author: Knight
 * new date: 2019/3/8 on 10:49
 * e-mail: 37442216knight@gmail.com
 * update: 2019/3/8 on 10:49
 * version: v 1.0
 */
interface ILifecycle {
    fun onCreate(savedInstanceState: Bundle?)
    fun onSaveInstanceState(outState: Bundle)
    fun onViewStateRestored(savedInstanceState: Bundle?)
    fun onConfigurationChanged(newConfig: Configuration)
    fun onDestroy()
    fun onStart()
    fun onStop()
    fun onResume()
    fun onPause()
}