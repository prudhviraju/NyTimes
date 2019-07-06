package com.nytimes.flows.dashboard.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.nytimes.BR
import com.nytimes.flows.dashboard.model.Result
import com.nytimes.flows.dashboard.viewmodel.DashBoardViewModel

class DashboardAdapter(@param:LayoutRes private val layoutId: Int,
                       private val viewModel: DashBoardViewModel)
    : RecyclerView.Adapter<DashboardAdapter.GridViewHolder>() {

    private var newsDataList: ArrayList<com.nytimes.flows.dashboard.model.Result> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater,
            viewType, parent, false)

        return GridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(viewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return layoutId
    }

    override fun getItemCount(): Int {
        return newsDataList.size
    }

    fun setDataList(dataObjects: ArrayList<Result>) {
        newsDataList.clear()
        newsDataList.addAll(dataObjects)
        notifyDataSetChanged()
    }


    class GridViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: DashBoardViewModel, position: Int?) {
            try {
                binding.setVariable(BR.socket, viewModel)
                binding.setVariable(BR.position, position)
                binding.executePendingBindings()
            } catch (e: Exception) {
                Log.d("...Error...", e.localizedMessage)
            }
        }
    }


}