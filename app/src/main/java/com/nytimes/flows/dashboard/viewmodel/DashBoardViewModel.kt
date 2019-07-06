package com.nytimes.flows.dashboard.viewmodel

import com.iii.photoapp.services.NyTimesServices
import com.nytimes.R
import com.nytimes.flows.dashboard.adapter.DashboardAdapter
import com.nytimes.flows.dashboard.model.Result
import com.nytimes.flows.dashboard.view.IView
import com.nytimes.shared.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class DashBoardViewModel : BaseViewModel(), IViewModel{

    private lateinit var mView:IView
    private lateinit var mNyTimesServices: NyTimesServices
    private val adapter = DashboardAdapter(R.layout.custom_dashboard_item, this)
    val dataList = ArrayList<Result>()

    override fun init(view: IView, mnyTimesServices: NyTimesServices) {
        mView = view
        mNyTimesServices = mnyTimesServices
        LoadNytTimesData()
    }

    private fun LoadNytTimesData(){
        mView.showProgressBar()
        mNyTimesServices.fetchDetails("all-sections","7","voo1j5P4i0tXFxolGsYGzGYQIeAFd0Zl")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onError = {
                    mView.hideProgressBar()
                },
                onNext = {
                    mView.hideProgressBar()
                    dataList.clear()
                    dataList.addAll(it.results)
                    adapter.setDataList(dataList)
                }
            )
    }

    /*fun photoRegularImage(position: Int):String{
        return dataList[position].urls.small
    }*/

    fun getDetailData(position: Int): Result {
        return dataList[position]
    }

    fun getAdapter(): DashboardAdapter {
        return adapter
    }


}