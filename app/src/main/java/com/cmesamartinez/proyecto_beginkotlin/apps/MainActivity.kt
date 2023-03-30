package com.cmesamartinez.proyecto_beginkotlin.apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.cmesamartinez.proyecto_beginkotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // start the app
        val button_hello = findViewById<AppCompatButton>(R.id.button_hello)
        val editText_name = findViewById<AppCompatEditText>(R.id.editText_name)

        button_hello.setOnClickListener{
            val name = editText_name.text.toString()
            if (name.isNotEmpty()){
                val intent = Intent(this,ResultActivity::class.java)
                intent.putExtra("Extra_Name",name)
               startActivity(intent)
            }
        }
    }
}