package com.knight.common

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * description: ${TODO}
 * author: Knight
 * new date: 2019/3/7 on 17:01
 * e-mail: 37442216knight@gmail.com
 * update: 2019/3/7 on 17:01
 * version: v 1.0
 */


class Preferences<T>(val context: Context, val name: String, val default: T, val perName: String = "default") :
    ReadWriteProperty<Any?, T> {

    private val perfs by lazy {
        context.getSharedPreferences(perName, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return  findPreference(name)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }

    private fun putPreference(key: String, value: T) {
        with(perfs.edit()) {
            when (value) {
                is String -> putString(key, value)
                is Long -> putLong(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                else -> throw IllegalArgumentException("Unsupported type.")
            }
        }.apply()
    }

    private fun findPreference(key: String): T {
        return when (default) {
            is String -> perfs.getString(key, default)
            is Long -> perfs.getLong(key, default)
            is Int -> perfs.getInt(key, default)
            is Boolean -> perfs.getBoolean(key,default)
            else -> throw IllegalArgumentException("Unsupported type.")
        } as T
    }

}