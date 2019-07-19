package com.example.hp.KotlinMVVMFirebaseApp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.hp.KotlinMVVMFirebaseApp.R
import com.google.firebase.auth.FirebaseAuth
import android.content.SharedPreferences
import android.widget.*
import android.util.Log
import android.content.SharedPreferences.Editor
import android.widget.EditText
import com.example.hp.KotlinMVVMFirebaseApp.model.PrefManager


class LoginActivity : AppCompatActivity() {
    var PREFS_NAME:String="PrefsFile"
    var PREFS_EMAIL:String=""
    var PREFS_PASS:String=""
    var saveLogin:Boolean=true
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var checkBox:CheckBox
    lateinit var prefs:SharedPreferences
    lateinit var editor: Editor
    private val PREF_NAME = "prefs"
    private val KEY_REMEMBER = "remember"
    private val KEY_USERNAME = "username"
    private val KEY_PASS = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        if (FirebaseAuth.getInstance().getCurrentUser()!=null) {
            //user's email and password both are saved in preferences
            val intent = Intent(this, JobListActivity::class.java)
            startActivity(intent)
        }


        email= findViewById<EditText>(R.id.emailEditText)
        password = findViewById<EditText>(R.id.passEditText)
        checkBox = findViewById(R.id.rememberMe)

        var loginbutton: Button =findViewById(R.id.login)

       /* prefs=getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor=prefs.edit()*/

        /*if(prefs.getBoolean(KEY_REMEMBER, false))
            checkBox.setChecked(true)
        else
            checkBox.setChecked(false)

        emailEditText.setText(prefs.getString(KEY_USERNAME,""));
        passEditText.setText(prefs.getString(KEY_PASS,""));

        emailEditText.addTextChangedListener(this)
        passEditText.addTextChangedListener(this)
        checkBox.setOnCheckedChangeListener(this)*/

        /*saveLogin=prefs.getBoolean("savelogin",false)
        if(saveLogin==true){
            emailEditText.setText(prefs.getString("username",""))
            passEditText.setText(prefs.getString("userpassword",""))
            checkBox.isChecked=true
        }*/




        loginbutton.setOnClickListener {
            userLogin();
        }

        var notRegistered:TextView=findViewById(R.id.signup)

        notRegistered.setOnClickListener { val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent) }
    }

    fun userLogin() {


        if (email.text.toString().isEmpty() || password.text.toString().isEmpty()) {
            Toast.makeText(this, "Enter all the details", Toast.LENGTH_SHORT).show()
            return
        }


        Log.d("checkbox","ongoing")

        /*var useremail=email.text.toString()
        var userpassword=password.text.toString()

        if(checkBox.isChecked){
            editor.putBoolean("saveLogin",true)
            editor.putString("username",useremail)
            editor.putString("userpassword",userpassword)
            editor.commit()
        }
        else{
            editor.clear()
            editor.commit()
        }
*/


        FirebaseAuth.getInstance().signInWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener {
                if (it.isSuccessful) {

                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, JobListActivity::class.java)
                    startActivity(intent)

                    if(checkBox.isChecked){
                        saveLoginDetails(email.text.toString(),password.text.toString())
                    }


                }

            }
            .addOnFailureListener {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }


    }
    fun saveLoginDetails(uemail:String,upass:String){
         PrefManager(this).saveLoginDetails(uemail, upass);
    }

}
