package com.cmesamartinez.proyecto_beginkotlin

fun main(){
    ifbasico()
}
fun ifanidado()
{
    val animal="dog"
    if(animal == "dog")
    {
        println("it is a dog")
    }else if (animal=="cat"){
        println("it is a cat")

    }
}
fun ifbasico()
{
    val name = "Carol2"
    if(name == "Carol")
    {
        println("la variable name es carol")
    }else{
        println("la variable name es carol2")

    }
}
fun ifint()
{
    var age=29
    if ( age>= 18)
    {
        print("drink")
    }else if(age<18)
    {
        println("not drink")
    }
}

fun ifmultipleandor()
{
    // entre parentesis otra condición
    var age=18
    var parentPermission = false
    var ishappy = true
    if(age>=18 && parentPermission)
    {
        println("can drink")
    }else if(age>=18 || parentPermission  || (!parentPermission && ishappy)){

    }
}
fun ifboolean()
{
    var ishappy:Boolean = true
    if(!ishappy)
    {
        print("estoy triste ")
    }
}