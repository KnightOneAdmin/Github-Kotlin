package com.knight.mvp

/**
 * description: ${TODO}
 * author: Knight
 * new date: 2019/3/8 on 10:43
 * e-mail: 37442216knight@gmail.com
 * update: 2019/3/8 on 10:43
 * version: v 1.0
 */
interface IPresenter<out View : IMvpView<IPresenter<View>>> :ILifecycle{
    val view: View
}

interface IMvpView<out Presenter : IPresenter<IMvpView<Presenter>>> :ILifecycle{
    val presenter: Presenter
}
