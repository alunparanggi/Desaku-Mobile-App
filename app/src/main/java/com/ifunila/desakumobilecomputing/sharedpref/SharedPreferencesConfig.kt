package com.ifunila.desakumobilecomputing.sharedpref

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesConfig(context: Context) {

    //shared preferences merupakan salah satu cara untuk menyimpan data
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

    //fungsi untuk menyimpan nik yang diinputkan pengguna
    fun setNIK(nik:String){
        val editor = sharedPreferences.edit()
        editor.putString(NIK, nik)
        editor.apply()
    }

    //fungsi untuk memanggil nik yang sebelumnya sudah diinputkan oleh pengguna
    fun getNIK():String{
        val nik = sharedPreferences.getString(NIK, "").toString()
        return nik
    }

    //fungsi untuk mengatur status login
    fun setLoginStatus(loginStatus: Boolean){
        val editor = sharedPreferences.edit()
        editor.putBoolean(LOGIN_STATUS, loginStatus)
        editor.apply()
    }

    //fungsi untuk memanggil status login, memiliki nilai default yaitu false
    fun getLoginStatus(): Boolean{
        val status = sharedPreferences.getBoolean(LOGIN_STATUS, false)
        return status
    }

    //deklarasi variabel konstanta dalam companion object
    companion object {
        const val SHARED_PREF = "sharedPrefs"
        const val NIK = "nik"
        const val LOGIN_STATUS = "login_status"
    }
}