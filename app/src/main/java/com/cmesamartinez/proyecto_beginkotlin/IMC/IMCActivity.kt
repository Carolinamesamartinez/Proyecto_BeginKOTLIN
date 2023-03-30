package com.cmesamartinez.proyecto_beginkotlin.IMC

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.cmesamartinez.proyecto_beginkotlin.R
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCActivity : AppCompatActivity() {
    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var textView_Height:TextView
    private lateinit var rsHeight:RangeSlider
    //by default
    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcactivity)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setGenderColor()
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
        rsHeight= findViewById(R.id.rsHeight)
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
            val result= df.format(value)
            //concat
            textView_Height.text="$result cm "
        }
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