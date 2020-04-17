package com.ifunila.desakumobilecomputing.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ifunila.desakumobilecomputing.R
import com.ifunila.desakumobilecomputing.sharedpref.SharedPreferencesConfig
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    //deklarasi object sharedpreferences
    lateinit var sharedPref : SharedPreferencesConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //inisialisasi object sharedpreferences
        sharedPref = SharedPreferencesConfig(this)

        //untuk mengecek apakah pengguna sudah login atau belum
        if (sharedPref.getLoginStatus() == false){

            Handler().postDelayed({

                //jika belum login maka akan otomatis masuk ke activity login
                startActivity(Intent(this, LoginActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()

            }, 1500)

        } else {

            Handler().postDelayed({

                //jika sudah login maka akan otomatis masuk ke activity dashboard
                startActivity(Intent(this, DashboardActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()

            }, 1500)

        }
    }
}
