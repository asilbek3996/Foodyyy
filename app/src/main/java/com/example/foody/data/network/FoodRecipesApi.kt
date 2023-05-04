package com.example.foody.data.network

import com.example.foody.models.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface FoodRecipesApi {

//    @Headers("apiKey : 1bc0dff2619b40b9bf497cdaf1d84d97")

    @GET("/recipes/complexSearch?")
    suspend fun getRecipes(
        @QueryMap queries:Map<String,String>
    ):Response<FoodRecipe>


}