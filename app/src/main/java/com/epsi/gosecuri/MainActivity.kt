package com.epsi.gosecuri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.doAsync
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doAsync {
            var doc = Jsoup.connect("").get()
        }

    }
}