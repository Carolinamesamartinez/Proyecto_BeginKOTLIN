package com.cmesamartinez.proyecto_beginkotlin.sintaxis

val name = "CarolinaMesa"

/**
 * values -> valor
 *      val nom
 *      You can specified the type of the val or not
 *      Android will choose the type that cost less space in memory
 */
fun main() {
    showMyName()
    showMyAge()
    add(25, 76)
    val resultSubtract = subtract(10, 5)
    println(resultSubtract)
}

fun varConcatCharString() {

    // Var and Val
    // int 2-647
    val age: Int = 30
    // long  -9 a 807
    val longInt: Long = 300
    // longInt2 is a int -> less space in memory
    val longInt2 = 300
    // float -> f at the end in the decimal number -> 6 decimals
    val floatNum: Float = 20.90f
    // double -> NOT  f at the end in the decimal number and 14 decimals
    val doubleNum: Double = 321.33333333334

    //char -> one characater
    val charExample: Char = 'c'
    // String
    val stringExample = "TextExample .. Hi"
    val stringExample2: String = "TextExample .. Hi"
    // boolean
    val booleanExample: Boolean = true
    val booleanExamplef: Boolean = false


    // operations diferent types of var and val

    //println(age+longInt)
    //println(age+floatNum)
    // We indicate the type of number that will be the result of the plus if we compare diferent types of alphanumerics numbers(var and val)
    var exampleSuma: Float = age + floatNum
    var exampleSuma2 = age + floatNum.toInt()

    //WARNING .toint will be working okay if the string CAN be converted (all the characters) to an int
    //23a to int NOO / 23 to int YES
    val stringExampleInt = "4"
    val stringExampleInt2 = "23"
    // concat two string
    //println(stringExampleInt+stringExampleInt2)

    // yo cannot plus a string with an int ->     println(stringExampleInt.toInt()+stringExampleInt2)
    //println(stringExampleInt.toInt()+stringExampleInt2.toInt())
    var stringConcat: String = "Hi"
    // call another var or val and concat with another var or val
    stringConcat = "My name is $name and i am  $age years old"
    println(stringConcat)
    val example: String = age.toString()

}

fun operations() {
    // val -> var (valor a variable)
    var agevar: Int = 30


    /**
     * print
    println(agevar) // print 30
    agevar= 29
    println(agevar) // changue value of the var print 29
    //print any type of val
    println(stringExample)
     **/
    /**
    // var and val can interact with eachother
    println("Suma :")
    println(age + agevar)

    println("Restar :")
    println(age - agevar)

    println("Multiplicar :")
    println(age * agevar)

    println("División :")
    println(age / agevar)

    println("Resto :")
    println(age % agevar)
     **/
}

fun showMyName() {
    println("Soy carol")
}

// with enter parameter
// if you dont send any enter parameter the program can wok with a default parameter
fun showMyAge(currentAge: Int = 30) {
    println("Tengo $currentAge años ")
}

fun add(firstNumber: Int, secondNumber: Int) {
    println(firstNumber+secondNumber)
}
// with enter and exit parameter

fun subtract(firstNumber: Int, secondNumber: Int):Int {
    return firstNumber-secondNumber
    // if you put any code below the return this wont work

}
//with less lines
fun subtract2(firstNumber: Int, secondNumber: Int):Int = firstNumber-secondNumber







