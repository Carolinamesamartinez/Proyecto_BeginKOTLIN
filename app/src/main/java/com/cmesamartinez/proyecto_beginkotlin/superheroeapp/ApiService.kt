package com.cmesamartinez.proyecto_beginkotlin.superheroeapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/224080986877328/search/super/{name}")
    suspend fun getSuperHeroes(@Path("name") superheroName:String):Response<SuperHeroeDataResponse>
    @GET("/api/224080986877328/{id}")
    suspend fun getSuperHeroeDetail(@Path("id") superheroName:String):Response<SuperHeroDetailResponse>



}