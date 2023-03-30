package com.cmesamartinez.proyecto_beginkotlin.sintaxis

fun main ()
{
    mutableList()
}

fun imnutableList(){
    //inmutables es decir solo lectura no se puede modificar el tamaño
    val readOnly:List<String> = listOf("Lunes","Martes","Miércoles","jueves","Viernes","sabado","domingo")
    println(readOnly.size)
    println(readOnly.toString())
    println(readOnly[0])
    println(readOnly.last())
    println(readOnly.first())

    // filter como for and it like i irt->iterarator
    val example= readOnly.filter{it .contains("a")}
    println(example)

    //the same , give the name of the iterator after like the first example
    readOnly.forEach{weekday -> println(weekday)}
    readOnly.forEach{println(it)}

}

fun mutableList()
{
    var weekDays:MutableList<String> = mutableListOf("Lunes","Martes","Miércoles","jueves","Viernes","sabado","domingo")
    println(weekDays)
    //añadimos a la posición 0 ( las demás van un paso atrás no se sobrescrien)
    weekDays.add(0,"CarolDay")
    println(weekDays)
    if(weekDays.isEmpty()){
        //empty
    }else{
        weekDays.forEach{println(it)}
    }
    if(weekDays.isNotEmpty()){
        weekDays.forEach{println(it)}

    }

    for (item in weekDays)
    {

    }
}