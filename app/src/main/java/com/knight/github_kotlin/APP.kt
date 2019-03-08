package com.knight.github_kotlin

import android.app.Application
import android.content.ContextWrapper

/**
 * description: ${TODO}
 * author: Knight
 * new date: 2019/3/7 on 17:20
 * e-mail: 37442216knight@gmail.com
 * update: 2019/3/7 on 17:20
 * version: v 1.0
 */

private lateinit var INSTANCE: Application

class APP : Application() {
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}


object AppContext : ContextWrapper(INSTANCE)