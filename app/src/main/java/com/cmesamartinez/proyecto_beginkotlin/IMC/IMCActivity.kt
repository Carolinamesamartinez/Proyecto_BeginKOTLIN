package com.cmesamartinez.proyecto_beginkotlin.IMC

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.cmesamartinez.proyecto_beginkotlin.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCActivity : AppCompatActivity() {
    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var textView_Height:TextView
    private lateinit var textView_Weight:TextView
    private lateinit var textView_Age:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var btnCalculate: Button
    //by default
    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight:Int=60
    private var currentAge:Int=60
    private var currentHeight:Int=120

    companion object{
        const val imc ="resultimc"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcactivity)
        initComponents()
        initListeners()
        initUI()
    }

    //inuui init the app with this values without press the any button
    private fun initUI() {
        setGenderColor()
        setweight()
        setAge()
    }
    // si clickea lo cambiamos de estado
    private fun changeGender(){
        isMaleSelected=!isMaleSelected
        isFemaleSelected=!isFemaleSelected
    }
    private fun initComponents() {
        viewMale= findViewById(R.id.viewMale)
        viewFemale= findViewById(R.id.viewFemale)
        textView_Height =findViewById(R.id.textView_Height)
        textView_Weight =findViewById(R.id.textView_weight)
        textView_Age =findViewById(R.id.textView_age)
        rsHeight= findViewById(R.id.rsHeight)
        btnSubtractWeight=findViewById(R.id.btnSubtractWeight)
        btnPlusWeight=findViewById(R.id.btnPlusWeight)
        btnSubtractAge=findViewById(R.id.btnSubtractAge)
        btnPlusAge=findViewById(R.id.btnPlusAge)
        btnCalculate=findViewById(R.id.btnCalcularIMC)

    }

    private fun initListeners() {
        //when is selected male of female -> setgendercolor and changegender (if is maleselected(true) change to women(false)) ...
        viewMale.setOnClickListener{ changeGender()
            setGenderColor()}
        viewFemale.setOnClickListener{changeGender()
            setGenderColor()}
        rsHeight.addOnChangeListener { _, value, _ ->
            //format the decimal format because we dont want the decimals
            val df= DecimalFormat("#.##")
             currentHeight= df.format(value).toInt()
            //concat
            textView_Height.text="$currentHeight cm "
        }
        btnSubtractWeight.setOnClickListener{
            currentWeight -= 1
            setweight()
        }
        btnPlusWeight.setOnClickListener{
            currentWeight += 1
            setweight()
        }
        btnSubtractAge.setOnClickListener {
            currentAge-=1
            setAge()
        }
        btnPlusAge.setOnClickListener {
            currentAge+= 1
            setAge()
        }
        btnCalculate.setOnClickListener {
           val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent= Intent(this,ResultIMCActivity::class.java)
        intent.putExtra(imc,result)
        startActivity(intent)
    }

    private fun calculateIMC():Double {
        val df= DecimalFormat("#,##")
        val imc= currentWeight/(currentHeight.toDouble()/100*currentHeight.toDouble()/100)
        return  df.format(imc).toDouble()
    }

    private fun setweight() {
        textView_Weight.text=currentWeight.toString()
    }
    private fun setAge() {
        textView_Age.text=currentAge.toString()
    }

    //enter parameter boolean
    private fun setGenderColor(){
        //set the color of the card -> needs a color -> getbackgrouncolor  return a color and we sent a boolean
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewMale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }


    // if the boolean is true we put the selected color and if not // and return the color in the two cases
    private fun getBackgroundColor(isSelectedComponent:Boolean) : Int{
        val colorReference = if(isSelectedComponent){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }

        return ContextCompat.getColor(this,colorReference)
    }
}