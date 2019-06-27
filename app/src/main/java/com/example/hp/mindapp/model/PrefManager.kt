package com.example.hp.mindapp.model

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.android.gms.flags.impl.SharedPreferencesFactory.getSharedPreferences
import android.content.SharedPreferences


class PrefManager internal constructor(internal var context: Context) {

    val email: String?
        get() {
            val sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
            return sharedPreferences.getString("Email", "")
        }

    val isUserLogedOut: Boolean
        get() {
            val sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
            val isEmailEmpty = sharedPreferences.getString("Email", "")!!.isEmpty()
            val isPasswordEmpty = sharedPreferences.getString("Password", "")!!.isEmpty()
            return isEmailEmpty || isPasswordEmpty
        }

    fun saveLoginDetails(email: String, password: String) {
        val sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("Email", email)
        editor.putString("Password", password)
        editor.commit()
    }
}