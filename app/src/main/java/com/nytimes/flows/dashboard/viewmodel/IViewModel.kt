package com.nytimes.flows.dashboard.viewmodel

import com.iii.photoapp.services.NyTimesServices
import com.nytimes.flows.dashboard.view.IView
import com.nytimes.shared.base.IBaseViewModel

interface IViewModel : IBaseViewModel {
    fun init(view: IView, mNyTimesServices: NyTimesServices)
}