package com.cmesamartinez.proyecto_beginkotlin.apps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.cmesamartinez.proyecto_beginkotlin.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val textView_hi = findViewById<TextView>(R.id.textView_hi)
        val name :String = intent.extras?.getString("Extra_Name").orEmpty()
        textView_hi.text = "Hola $name"
    }
}