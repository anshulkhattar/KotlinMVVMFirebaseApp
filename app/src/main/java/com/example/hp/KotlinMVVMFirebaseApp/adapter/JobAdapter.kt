package com.example.hp.KotlinMVVMFirebaseApp.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.hp.KotlinMVVMFirebaseApp.R
import com.example.hp.KotlinMVVMFirebaseApp.databinding.JobdisplaydesignBinding
import com.example.hp.KotlinMVVMFirebaseApp.viewmodel.JobListViewModel


class JobAdapter(private val context: Context , private val arrayList: ArrayList<JobListViewModel>):
    RecyclerView.Adapter<JobAdapter.customView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customView {

        val layoutInflater=LayoutInflater.from(parent.context)

        val jobdisplaydesignBinding:JobdisplaydesignBinding=DataBindingUtil.inflate(layoutInflater,R.layout.jobdisplaydesign,parent,false)

        return customView(jobdisplaydesignBinding)
    }

    override fun getItemCount(): Int {


        return arrayList.size
    }

    override fun onBindViewHolder(holder: customView, position: Int) {

        val jobListViewModel=arrayList[position]
        holder.bind(jobListViewModel)
    }


    class customView(val jobdisplaydesignBinding: JobdisplaydesignBinding):RecyclerView.ViewHolder(jobdisplaydesignBinding.root){

        fun bind(jobListViewModel: JobListViewModel){



            this.jobdisplaydesignBinding.jobmodel=jobListViewModel
            jobdisplaydesignBinding.executePendingBindings()
        }

    }
}