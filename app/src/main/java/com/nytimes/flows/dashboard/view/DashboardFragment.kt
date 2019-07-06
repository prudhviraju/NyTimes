package com.nytimes.flows.dashboard.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.iii.photoapp.services.NyTimesServices
import com.nytimes.R
import com.nytimes.databinding.FragmentDashboardBinding
import com.nytimes.flows.dashboard.viewmodel.DashBoardViewModel
import com.nytimes.shared.base.BaseFragment

class DashboardFragment:BaseFragment(),IView{

    lateinit var mBinding: FragmentDashboardBinding
    lateinit var mViewModel: DashBoardViewModel
    companion object {
        fun newInstance() = DashboardFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(DashBoardViewModel::class.java)
        mViewModel.init(this,NyTimesServices.NyTimesServicesCreator.newService(Gson()))
        mBinding.socket = mViewModel
    }
}