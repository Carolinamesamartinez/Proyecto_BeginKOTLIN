package com.cmesamartinez.proyecto_beginkotlin

fun main()
{
// tamaño fijo
    val weekDays = arrayOf("Lunes","Martes","Miércoles","jueves","Viernes","sabado","domingo")
    println(weekDays[0]) //lunes
    println(weekDays[7])// da error
    println(weekDays.size)
    if (weekDays.size>=8)
    {
        println(weekDays[7])
    }else{
        println("no hay más valores ")

    }
    //modify values in the array
    weekDays[0]= "newday"
    println(weekDays[0])

    //loops in arrays
    for (position in weekDays.indices)
    {
        println(weekDays[position])
    }

    for((position, value) in weekDays.withIndex())
    {
        println("posicion: $position value : $value")
    }

    for (weekday in weekDays)
    {
        println("lista : $weekday")
    }
    weekDays.forEach { println(it) }

}