package com.example.foody.data

import com.example.foody.data.database.RecipeEntity
import com.example.foody.data.database.RecipesDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val recipeDao: RecipesDao
) {


    fun readDatabase(): Flow<List<RecipeEntity>> {
        return recipeDao.readRecipes()
    }

    suspend fun insertRecipes(recipeEntity: RecipeEntity){
        recipeDao.insertRecipes(recipeEntity)
    }

}