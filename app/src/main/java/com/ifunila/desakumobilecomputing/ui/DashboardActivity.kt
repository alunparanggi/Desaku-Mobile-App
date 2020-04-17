package com.ifunila.desakumobilecomputing.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ifunila.desakumobilecomputing.R
import com.ifunila.desakumobilecomputing.sharedpref.SharedPreferencesConfig
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    //deklarasi object sharedpreferences
    lateinit var sharedPref : SharedPreferencesConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        //inisialisasi object sharedpreferences
        sharedPref = SharedPreferencesConfig(this)

        //memanggil fungsi
        initView()
        onClickListener()
    }

    //deklarasi fungsi
    private fun initView() {
        //deklarasi dan inisialisasi variabel nik
        val nik = sharedPref.getNIK() //mengambil nik dari shared preferences
        tv_nik_dashboard.text = nik //mengganti nik sesuai dengan yang ada di shared preferences
    }


    //deklarasi fungsi, untuk memberi aksi kepada button button yang terdapat di dashboard activity
    private fun onClickListener() {

        btn_pengajuan_surat.setOnClickListener {
            //pindah ke pengajuan surat activity
            startActivity(Intent(this, PengajuanSuratActivity::class.java))
        }

        btn_acara.setOnClickListener {
            //pindah ke acara activity
            startActivity(Intent(this, AcaraActivity::class.java))
        }

        btn_kritik_saran.setOnClickListener {
            //pindah ke kritik saran activity
            startActivity(Intent(this, KritikSaranActivity::class.java))
        }

        btn_notif.setOnClickListener {
            //pindah ke notifikasi activity
            startActivity(Intent(this, NotifActivity::class.java))
        }

        btn_logout.setOnClickListener {

            //untuk menampilkan toast
            Toast.makeText(this, "Logout Berhasil", Toast.LENGTH_SHORT).show()

            //pindah ke login activity sekaligus mengubah status login menjadi false
            sharedPref.setLoginStatus(false)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }
}
