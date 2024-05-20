package com.bumantra.myanimals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AboutPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        supportActionBar?.apply {
            title = getString(R.string.about)
        }
    }
}