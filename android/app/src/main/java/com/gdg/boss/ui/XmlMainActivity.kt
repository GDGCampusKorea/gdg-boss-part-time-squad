package com.gdg.boss.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdg.boss.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class XmlMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
