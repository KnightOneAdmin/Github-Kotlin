package com.knight.github_kotlin

import com.knight.common.Preferences

/**
 * description: ${TODO}
 * author: Knight
 * new date: 2019/3/7 on 17:17
 * e-mail: 37442216knight@gmail.com
 * update: 2019/3/7 on 17:17
 * version: v 1.0
 */

object Settings {
    var email: String by Preferences(AppContext, "email", "")
    var password: String by Preferences(AppContext, "password", "")
}