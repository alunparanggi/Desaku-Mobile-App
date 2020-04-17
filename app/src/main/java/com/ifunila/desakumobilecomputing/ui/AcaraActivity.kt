package com.ifunila.desakumobilecomputing.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ifunila.desakumobilecomputing.R
import kotlinx.android.synthetic.main.activity_acara.*

class AcaraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acara)

        //mengatur toolbar
        setSupportActionBar(tb_acara)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //memanggil fungsi onClickListener
        onClickListener()
    }

    private fun onClickListener(){

        //menentukan aksi ketika button detail di klik
        btn_detail_acara.setOnClickListener {
            val i = Intent(this, DetailAcaraActivity::class.java)
            i.putExtra(NAMA_ACARA, "Pengajian Sekaligus Buka Bersama")
            i.putExtra(TANGGAL_ACARA, "Jumat, 24 April 2020")
            i.putExtra(JAM, "17:00 WIB")
            i.putExtra(LOKASI_ACARA, "MASJID AGUNG")
            i.putExtra(DRESSCODE, "Pakaian Muslim")
            startActivity(i)
        }

        //menentukan aksi ketika button detail di klik
        btn_detail_acara_sdh.setOnClickListener {
            val i = Intent(this, DetailAcaraActivity::class.java)
            i.putExtra(NAMA_ACARA, "Rapat Penanganan Covid-19")
            i.putExtra(TANGGAL_ACARA, "Kamis, 16 April 2020")
            i.putExtra(JAM, "09:00 WIB")
            i.putExtra(LOKASI_ACARA, "BALAI DESA")
            i.putExtra(DRESSCODE, "Kemeja/Batik")
            startActivity(i)
        }
    }

    //deklarasi companion object
    companion object {
        const val NAMA_ACARA = "nama_acara"
        const val TANGGAL_ACARA = "tanggal"
        const val LOKASI_ACARA = "lokasi"
        const val DRESSCODE = "dc"
        const val JAM = "jam"
    }
}
