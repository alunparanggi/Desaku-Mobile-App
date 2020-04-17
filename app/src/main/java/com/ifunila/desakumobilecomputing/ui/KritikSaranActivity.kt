package com.ifunila.desakumobilecomputing.ui

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ifunila.desakumobilecomputing.R
import kotlinx.android.synthetic.main.activity_kritik_saran.*
import kotlinx.android.synthetic.main.item_popup_kritiksaran.*

class KritikSaranActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kritik_saran)

        //mengatur toolbar
        setSupportActionBar(tb_kritiksaran)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //memanggil fungsi
        onClickListener()
    }

    //deklarasi fungsi, untuk memberi aksi button kirim kritik saran
    private fun onClickListener(){
        btn_kirim_kritiksaran.setOnClickListener {

            if (et_kritiksaran.text.toString().length == 0) {
                et_kritiksaran.error = "Kritik saran masih kosong!"
            } else {
                showPopupRequest()
            }
        }
    }

    //deklarasi fungsi, untuk menampilkan pop up keterangan bahwa kritik saran berhasil terkirim
    private fun showPopupRequest() {
        val epicDialog = Dialog(this)

        epicDialog.setContentView(R.layout.item_popup_kritiksaran)
        epicDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        epicDialog.show()

        epicDialog.btn_kembali_kritik.setOnClickListener {
            epicDialog.dismiss()
            val intent = Intent(this, DashboardActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }
}
