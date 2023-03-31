package com.cmesamartinez.proyecto_beginkotlin.IMC

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.cmesamartinez.proyecto_beginkotlin.IMC.IMCActivity.Companion.imc
import com.cmesamartinez.proyecto_beginkotlin.R

class ResultIMCActivity : AppCompatActivity() {
    private lateinit var tvresult:TextView
    private lateinit var tvimc:TextView
    private lateinit var tvtvdescriptionresult:TextView
    private lateinit var btnrecalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result:Double = intent.extras?.getDouble(imc)?:-1.0
        initcomponents()
        initUI(result)
        initlisteners()
    }

    private fun initlisteners() {
        btnrecalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvimc.text=result.toString()
        when(result){
            in 0.00 .. 18.50 ->{
                tvresult.text=getString(R.string.tittle_lowweight)
                tvresult.setTextColor(ContextCompat.getColor(this,R.color.lowweight))
                tvtvdescriptionresult.text=getString(R.string.description_lowweight)
            }
            in 18.51 .. 24.99 ->{getString(R.string.error)
                tvresult.text=getString(R.string.tittle_normalweight)
                tvresult.setTextColor(ContextCompat.getColor(this,R.color.normalweight))
                tvtvdescriptionresult.text=getString(R.string.description_normalweight)
            }
            in 25.00 .. 29.99 ->{
                tvresult.text=getString(R.string.tittle_overweight)
                tvresult.setTextColor(ContextCompat.getColor(this,R.color.overweight))
                tvtvdescriptionresult.text=getString(R.string.description_overweight)
            }
            in 30.00 .. 99.99 ->{
                tvresult.text=getString(R.string.tittle_over2weight)
                tvresult.setTextColor(ContextCompat.getColor(this,R.color.over2weight))
                tvtvdescriptionresult.text=getString(R.string.description_over2weight)
            }
            else -> {
                tvimc.text=getString(R.string.error)
                tvresult.text=getString(R.string.error)
                tvresult.setTextColor(ContextCompat.getColor(this,R.color.over2weight))
                tvtvdescriptionresult.text=getString(R.string.error)
            }
        }
    }

    private fun initcomponents() {
        tvresult=findViewById(R.id.tvresult)
        tvimc=findViewById(R.id.tvimc)
        tvtvdescriptionresult=findViewById(R.id.tvDescription)
        btnrecalculate=findViewById(R.id.btnreCalcularIMC)
    }
}