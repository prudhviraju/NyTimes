package com.nytimes.flows.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nytimes.R
import com.nytimes.databinding.ActivityDashboardBinding
import com.nytimes.flows.dashboard.view.DashboardFragment
import com.nytimes.shared.base.BaseActivity

class DashBoardActivity : BaseActivity() {

    lateinit var mBinding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_dashboard, parentViewGroup,
            true)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DashboardFragment.newInstance())
                .commitNow()
        }
    }
}
