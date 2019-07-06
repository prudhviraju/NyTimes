package com.nytimes.shared.base

import com.nytimes.shared.viewmodel.ObservableViewModel


abstract class BaseViewModel : ObservableViewModel(), IBaseViewModel {

    open lateinit var baseView: IBaseView
}