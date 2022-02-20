package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.view.Window
import android.widget.Button
import android.widget.TextView
// null to remove nullable exceptions
private var tvinput: TextView? = null
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        tvinput=findViewById(R.id.tvinput)

    }

    fun digit(view: android.view.View) {
        tvinput?.append((view as Button).text)
    }
    fun clear(view: android.view.View) {
        tvinput?.text=""
    }
}