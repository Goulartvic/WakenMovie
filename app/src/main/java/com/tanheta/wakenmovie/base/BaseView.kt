package com.tanheta.wakenmovie.base

interface BaseView<out T : BasePresenter<*>> {
    val presenter: T
}