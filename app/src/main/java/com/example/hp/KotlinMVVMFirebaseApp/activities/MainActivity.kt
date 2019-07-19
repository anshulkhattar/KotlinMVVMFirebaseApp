package com.example.hp.KotlinMVVMFirebaseApp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.hp.KotlinMVVMFirebaseApp.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (FirebaseAuth.getInstance().getCurrentUser()!=null) {
            //user's email and password both are saved in preferences
            val intent = Intent(this, JobListActivity::class.java)
            startActivity(intent)
        }

        val signup : Button =findViewById(R.id.button)
        val signin:Button=findViewById(R.id.button2)

        signup.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        signin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
