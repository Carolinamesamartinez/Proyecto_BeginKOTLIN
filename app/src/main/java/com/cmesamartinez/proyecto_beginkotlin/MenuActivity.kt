package com.cmesamartinez.proyecto_beginkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.cmesamartinez.proyecto_beginkotlin.IMC.IMCActivity
import com.cmesamartinez.proyecto_beginkotlin.apps.MainActivity
import com.cmesamartinez.proyecto_beginkotlin.apps.ResultActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val button_goHiApp = findViewById<AppCompatButton>(R.id.button_goHiApp)
        val button_IMCApp = findViewById<AppCompatButton>(R.id.button_IMCApp)

        button_goHiApp.setOnClickListener{
            navigateToHiApp()
        }
        button_IMCApp.setOnClickListener{
            navigateToIMCApp()
        }
    }

   private fun navigateToHiApp(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp(){
        val intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }

}