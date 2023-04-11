package com.cmesamartinez.proyecto_beginkotlin.TODOApp

data class Task (val name:String,val category: TaskCategory, var isSelected:Boolean=false)

