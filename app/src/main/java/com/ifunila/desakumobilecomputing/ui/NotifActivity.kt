package com.ifunila.desakumobilecomputing.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ifunila.desakumobilecomputing.R
import kotlinx.android.synthetic.main.activity_notif.*

class NotifActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notif)

        //mengatur toolbar
        setSupportActionBar(tb_notif)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
}
