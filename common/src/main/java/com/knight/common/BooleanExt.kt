package com.knight.common

/**
 * description: ${TODO}
 * author: Knight
 * new date: 2019/3/7 on 16:31
 * e-mail: 37442216knight@gmail.com
 * update: 2019/3/7 on 16:31
 * version: v 1.0
 */

sealed class BooleanExt

object Otherwise : BooleanExt()
class WithData : BooleanExt()

inline fun Boolean.yes(block: () -> Unit) =
    when {
        this -> {
            block()
            WithData()
        }
        else -> {
            Otherwise
        }
    }

fun BooleanExt.otherwise(block: () -> Unit) =
    when (this) {
        is Otherwise -> block()
        is WithData -> Unit
    }
