package com.knight.impl

import android.support.v4.app.Fragment
import com.knight.mvp.IMvpView

/**
 * description: ${TODO}
 * author: Knight
 * new date: 2019/3/8 on 13:29
 * e-mail: 37442216knight@gmail.com
 * update: 2019/3/8 on 13:29
 * version: v 1.0
 */
class BaseFragment<out P : BasePresenter<BaseFragment<P>>> : IMvpView<P>, Fragment() {

    override val presenter: P

    init {
        presenter = createPresenter()
        presenter.view = this
    }

    fun createPresenter(): P = TODO()
}