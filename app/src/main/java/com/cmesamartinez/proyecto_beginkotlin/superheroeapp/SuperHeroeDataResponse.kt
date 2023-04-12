package com.cmesamartinez.proyecto_beginkotlin.superheroeapp

import com.google.gson.annotations.SerializedName
// seralizedname -> "response" of json equals val response (match the strings)
data class SuperHeroeDataResponse(
                        @SerializedName("response") val response: String,
                        @SerializedName("results") val superheroes:List<SuperHeroItemResponse>)

data class SuperHeroItemResponse(
    @SerializedName("id") val superheroid:String,
    @SerializedName("name") val name:String,
    @SerializedName("image") val superheroimage:SuperHeroImageResponse,
)
data class SuperHeroImageResponse(
    @SerializedName("url") val url:String,
)

