package com.ifunila.desakumobilecomputing.ui

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ifunila.desakumobilecomputing.R
import kotlinx.android.synthetic.main.activity_pengajuan_surat.*
import kotlinx.android.synthetic.main.item_popup_request.*

class PengajuanSuratActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengajuan_surat)

        //mengatur toolbar
        setSupportActionBar(tb_pengajuan)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //memanggil fungsi
        onClickListener()
    }

    //deklarasi fungsi, untuk memberi aksi button
    private fun onClickListener(){
        btn_lanjut.setOnClickListener {

            //untuk memastikan pengguna sudah memilih jenis surat
            if (sp_jenis_surat.selectedItem.toString().equals("Pilih Jenis Surat")) {
                tv_error_sp.visibility = View.VISIBLE
            } else {

                tv_error_sp.visibility = View.GONE

                //untuk mengecek apakah masih ada form biodata yang kosong
                if (et_agama.text.toString().length == 0 ||
                    et_desa.text.toString().length == 0 ||
                    et_kabupaten.text.toString().length == 0 ||
                    et_kecamatan.text.toString().length == 0 ||
                    et_nama.text.toString().length == 0 ||
                    et_rt.text.toString().length == 0 ||
                    et_rw.text.toString().length == 0 ||
                    et_pekerjaan.text.toString().length == 0) {
                    tv_error_bio.visibility = View.VISIBLE
                } else {
                    showPopupRequest()
                }
            }

        }
    }

    //deklarasi fungsi, untuk menampilkan pop up keterangan bahwa pengajuan surat berhasil
    private fun showPopupRequest() {
        val epicDialog = Dialog(this)

        epicDialog.setContentView(R.layout.item_popup_request)
        epicDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        epicDialog.show()

        epicDialog.btn_kembali.setOnClickListener {
            epicDialog.dismiss()
            val intent = Intent(this, DashboardActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }
}
