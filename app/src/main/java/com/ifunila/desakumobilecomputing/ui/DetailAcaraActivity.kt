package com.ifunila.desakumobilecomputing.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ifunila.desakumobilecomputing.R
import kotlinx.android.synthetic.main.activity_detail_acara.*

class DetailAcaraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_acara)

        //mengatur toolbar
        setSupportActionBar(tb_detail_acara)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //memanggil fungsi
        initView()
    }

    //deklarasi fungsi
    private fun initView() {

        //deklarasi dan inisialisasi variabel
        val namaAcara = intent.getStringExtra(AcaraActivity.NAMA_ACARA)
        val lokasiAcara = intent.getStringExtra(AcaraActivity.LOKASI_ACARA)
        val tanggalAcara = intent.getStringExtra(AcaraActivity.TANGGAL_ACARA)
        val jamAcara = intent.getStringExtra(AcaraActivity.JAM)
        val dresscodeAcara = intent.getStringExtra(AcaraActivity.DRESSCODE)

        //untuk mengubah detail kegiatan sesuai dengan acara yang dipilih
        tv_detail_nama_acara.text = namaAcara?.toString()
        tv_lokasi_detail.text = lokasiAcara?.toString()
        tv_jam_detail.text = jamAcara?.toString()
        tv_tanggal_detail.text = tanggalAcara?.toString()
        tv_dresscode_detail.text = dresscodeAcara?.toString()
    }
}
