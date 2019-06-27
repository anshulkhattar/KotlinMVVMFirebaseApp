package com.example.hp.mindapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.hp.mindapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val mAuth=FirebaseAuth.getInstance()

        val submitButton : Button=findViewById(R.id.submit)

        submitButton.setOnClickListener { regsiterUser() }

        var alreadyRegistered: TextView =findViewById(R.id.alreadyRegistered)

        alreadyRegistered.setOnClickListener { val intent = Intent(this,
            LoginActivity::class.java)
            startActivity(intent) }
    }

    fun regsiterUser(){

        var mName=findViewById<EditText>(R.id.name)
        var mEmail=findViewById<EditText>(R.id.email)
        var mPassword=findViewById<EditText>(R.id.password)
        var mPhone=findViewById<EditText>(R.id.phnNO)
        var name:String=mName.text.toString()
        var emailid:String=mEmail.text.toString()
        var pass:String=mPassword.text.toString()
        var phnnum:String=mPhone.text.toString()
        Log.d("before write","before")
        if(name.isEmpty() || emailid.isEmpty() || pass.isEmpty() || phnnum.isEmpty()) {
            Toast.makeText(this,"Enter all the details",Toast.LENGTH_SHORT).show()
            return}

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailid,pass)
            .addOnCompleteListener { if(!it.isSuccessful) return@addOnCompleteListener

                var user= User(name, emailid, phnnum)
                FirebaseDatabase.getInstance().getReference(" Users")
                    .child(FirebaseAuth.getInstance().currentUser!!.uid)
                    .setValue(user)


                Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
                Log.d("druing write","during ${it.result.user.uid}")

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

            }
            .addOnFailureListener {
                Toast.makeText(this,"Registration Unsuccessful",Toast.LENGTH_SHORT).show()
                Log.d("after write","failed")
            }


    }
}

data class User(val uname:String,val uemail:String,val uphone:String)
