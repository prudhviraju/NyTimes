package com.nytimes.shared.base

import android.view.View
import androidx.fragment.app.Fragment
import com.iii.photoapp.extensions.showAlertDialog
import com.iii.photoapp.extensions.showToast

abstract class BaseFragment : Fragment(), IBaseView {

    lateinit var progressBar: View

    override fun showError(s: String) {
        showToast(context!!, s)
    }

    override fun showErrorDialog(array: Array<String>) {
        if (context != null) {
            showAlertDialog(context!!, array[0], array[1])
        }
    }

    override fun showProgressBar() {
        if (context != null) {
            (context!! as BaseActivity).showProgressBar()
        }
    }

    override fun hideProgressBar() {
        if (context != null) {
            (context!! as BaseActivity).hideProgressBar()
        }
    }
}