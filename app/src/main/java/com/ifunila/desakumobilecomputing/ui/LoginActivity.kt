package com.ifunila.desakumobilecomputing.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ifunila.desakumobilecomputing.R
import com.ifunila.desakumobilecomputing.sharedpref.SharedPreferencesConfig
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    //deklarasi object sharedpreferences
    lateinit var sharedPref : SharedPreferencesConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //inisialisasi object sharedpreferences
        sharedPref = SharedPreferencesConfig(this)

        //aksi ketika button login di klik
        btn_login.setOnClickListener {

            //deklarasi dan inisialisasi variabel nik
            val nik = et_nik.text.toString() //nik yang diinput oleh pengguna

            //mengecek validasi nik berdasarkan jumlah nik
            if (nik.length == 16) {

                sharedPref.setNIK(nik) //menyimpan nik ke shared preferences
                sharedPref.setLoginStatus(true) //menyimpan login status ke shared preferences menjadi true
                startActivity(Intent(this, DashboardActivity::class.java)) //pindah ke dashboard
                finish()

            } else { //jika pas 16

                //jika nik tidak sama dengan 16, maka akan tampil error
                et_nik.error = "NIK tidak valid! Silahkan coba lagi"

            }

        }
    }
}
