package com.example.hp.KotlinMVVMFirebaseApp.activities

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import com.example.hp.KotlinMVVMFirebaseApp.viewmodel.JobListViewModel
import com.example.hp.KotlinMVVMFirebaseApp.R
import com.example.hp.KotlinMVVMFirebaseApp.adapter.JobAdapter
import com.google.firebase.auth.FirebaseAuth


class JobListActivity : AppCompatActivity() {

    private var jobAdapter:JobAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_list)


        var signout:Button=findViewById(R.id.signout)

        signout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        var recyclerview= this.findViewById<RecyclerView>(R.id.jobrecyclerview)


        var jobListViewModel:JobListViewModel=ViewModelProviders.of(this).get(JobListViewModel::class.java)

        jobListViewModel.getArrayList().observe(this, android.arch.lifecycle.Observer {jobListViewModel->

            jobAdapter = JobAdapter(this@JobListActivity, jobListViewModel!!)
            recyclerview.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

            //recyclerview!!.layoutManager = LinearLayoutManager(this@JobListActivity)
            recyclerview!!.adapter = jobAdapter
        })

    }
}