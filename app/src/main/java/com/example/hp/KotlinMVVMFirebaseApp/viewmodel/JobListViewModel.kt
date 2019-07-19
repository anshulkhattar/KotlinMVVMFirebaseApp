package com.example.hp.KotlinMVVMFirebaseApp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.hp.KotlinMVVMFirebaseApp.model.Jobs
import com.google.firebase.database.*

class JobListViewModel: ViewModel {

    var jobName:String=""
    var jobDuration:String=""
    var jobStatus:String=""


    constructor() : super()
    constructor(job: Jobs) : super() {
        this.jobName = job.name
        this.jobDuration = job.duration
        this.jobStatus = job.status
    }


    var arrayListMutableLiveData=MutableLiveData<ArrayList<JobListViewModel>>()

    var arrayList=ArrayList<JobListViewModel>()

    fun getArrayList():MutableLiveData<ArrayList<JobListViewModel>>{

        val jobListener = FirebaseDatabase.getInstance().getReference("Jobs")
        jobListener.addValueEventListener(object : ValueEventListener {


            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (jobSnapshot in dataSnapshot.children) {
                        var job:Jobs = jobSnapshot.getValue(Jobs::class.java)!!

                        var jobs= JobListViewModel(job)

                        arrayList!!.add(jobs)

                        arrayListMutableLiveData.value=arrayList


                    }
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })


        /*val job1=Jobs("Cleaner","2hrs","accepted")
        val job2=Jobs("Driver","1day","Declined")

        val jobListViewModel1= JobListViewModel(job1)
        val jobListViewModel2 =JobListViewModel(job2)

        arrayList!!.add(jobListViewModel1)
        arrayList!!.add(jobListViewModel2)

        arrayListMutableLiveData.value=arrayList*/


        return arrayListMutableLiveData
    }


}


