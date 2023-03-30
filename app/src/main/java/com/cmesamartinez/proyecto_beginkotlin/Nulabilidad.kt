package com.cmesamartinez.proyecto_beginkotlin

fun main(){
    // si name no es nulo dame la pos 3 si no es nullo(print)
    var name:String?= "carol"
    println(name?.get(3)?:"es nulo")
}
