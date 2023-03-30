package com.cmesamartinez.proyecto_beginkotlin

fun main(){
    getMonth(1)
}
fun result(value:Any)
{
    when(value){
        is Int -> value + value
        is String -> println(value)
        is Boolean -> if(value) print("corect")
    }
}

fun getSemester3(str:Int):String
{
    val result = when(str){
        in 1 .. 6-> "first"

        in 7 .. 12-> "second"
        !in 1 .. 12 -> "invalid"
        else -> "invalid 2 obligatoire"
    }
    return result
}

fun getSemester4(str:Int):String
{
   return  when(str){
        in 1 .. 6-> "first"

        in 7 .. 12-> "second"
        !in 1 .. 12 -> "invalid"
        else -> "invalid 2 obligatoire"
    }

}
fun getSemester5(str:Int):String =
    when(str){
        in 1 .. 6-> "first"

        in 7 .. 12-> "second"
        !in 1 .. 12 -> "invalid"
        else -> "invalid 2 obligatoire"
    }


// 1-3 (1,2,3)
fun getSemester1(str:Int)
{
    when(str){
        in 1 .. 3->{println("first trimester")
            println("1,2,3")
        }
        in 800 .. 900-> println("what")
        else -> println("rest of the months")
    }
}

fun getSemester2(str:Int)
{
    when(str){
        in 1 .. 6->{println("first semester")
            println("1,2,3")
        }
        in 7 .. 12-> println("second")
        !in 1 .. 12 -> println("invalid")
    }
}
fun getTrimester(trm:Int)
{
    when(trm){
        1,2,3->{println("first trimester")
                println("1,2,3")
        }
        else -> println("rest of the months")
    }
}
// like switch
//more tha one else if
fun getMonth(month:Int)
{
    when(month){
        1->println("enero")
        else -> println("rest of the months")
    }
}