package com.nytimes.shared.base

interface IBaseView {
    fun showError(s: String)

    fun showErrorDialog(array: Array<String>)

    fun showProgressBar()

    fun hideProgressBar()
}