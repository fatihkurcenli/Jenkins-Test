package com.autumnsun.jenkinsbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a = findViewById<TextView>(R.id.txt_hello_text)
        a.text = "ChangedName"//hello working test moruq
        Log.e("second", "second")
    }
}