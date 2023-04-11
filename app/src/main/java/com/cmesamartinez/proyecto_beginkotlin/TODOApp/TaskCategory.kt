package com.cmesamartinez.proyecto_beginkotlin.TODOApp

sealed class TaskCategory (var isSelected:Boolean=true){
    object Personal:TaskCategory()
    object Business:TaskCategory()
    object Other:TaskCategory()
}