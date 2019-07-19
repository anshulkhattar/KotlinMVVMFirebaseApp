package com.example.hp.KotlinMVVMFirebaseApp.model

class Jobs {
    var name: String = ""
    var duration: String = ""
    var status: String = ""

    constructor()

    constructor(jobDuration: String, jobName: String, jobStatus: String) {
        this.name = jobName
        this.duration = jobDuration
        this.status = jobStatus
    }

    /*fun setjobName(name:String) {
        jobName=name
    }

   fun setjobDuration(duration:String) {
        jobDuration=duration
    }

    fun setjobStatus(status:String) {
        jobStatus=status
    }*/

    /*fun getjobDuration(): String {
        return jobDuration
    }

    fun getjobName(): String {
        return jobName
    }



    fun getjobStatus(): String {
        return jobStatus
    }*/
}