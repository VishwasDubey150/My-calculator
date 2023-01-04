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
var lastNumeric: Boolean = false

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        tvinput=findViewById(R.id.tvinput)

    }
    fun digit(view: android.view.View) {
        tvinput?.append((view as Button).text)
        lastNumeric=true
    }
    fun clear(view: android.view.View) {
        tvinput?.text=""
        lastNumeric=false
    }
    fun onoperators(view: View) {
        tvinput?.text?.let {
            if(lastNumeric && !isoperatoradded(it.toString()))
            {
                tvinput?.append((view as Button).text)
                lastNumeric = false
            }
        }
    }

    fun isoperatoradded(value: String):Boolean {
        return if(value.startsWith("-"))
        {
            false
        }
        else {
            value.contains("/")
                    ||value.contains("+")
                    ||value.contains("-")
                    ||value.contains("*")
        }
    }

    fun isequalto(view: View) {
        if(lastNumeric)
        {
            var prefix=""
            var value= tvinput?.text.toString()
            try {
                if (value.startsWith("-")) {
                    prefix = "-"
                    value = value.substring(1)
                }
                if (value.contains("-")) {
                    val splitValue = value.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty())
                    {
                        one=prefix+one
                    }
                    tvinput?.text = (one.toDouble() - two.toDouble()).toString()
                }
                if (value.contains("+")) {
                    val splitValue = value.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty())
                    {
                        one=prefix+one
                    }
                    tvinput?.text = (one.toDouble() + two.toDouble()).toString()
                }
                if (value.contains("*")) {
                    val splitValue = value.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty())
                    {
                        one=prefix+one
                    }
                    tvinput?.text = (one.toDouble() * two.toDouble()).toString()
                }
                if (value.contains("/")) {
                    val splitValue = value.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty())
                    {
                        one=prefix+one
                    }
                    tvinput?.text = (one.toDouble() / two.toDouble()).toString()
                }
            }
            catch
                (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }
}