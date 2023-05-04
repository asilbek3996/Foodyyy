package com.example.foody.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.foody.R
import com.example.foody.databinding.ActivityMainBinding
import com.example.foody.ui.fragments.favorites.FavoriteRecipesFragment
import com.example.foody.ui.fragments.foodjoke.FoodJokeFragment
import com.example.foody.ui.fragments.recipes.RecipesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val recipesFragment = RecipesFragment()
    val favoriteRecipesFragment = FavoriteRecipesFragment()
    val foodJokeFragment = FoodJokeFragment()
    var activeFragment:Fragment = recipesFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.flContainer,recipesFragment,recipesFragment.tag).hide(recipesFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flContainer,favoriteRecipesFragment,favoriteRecipesFragment.tag).hide(favoriteRecipesFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flContainer,foodJokeFragment,foodJokeFragment.tag).hide(foodJokeFragment).commit()
        supportFragmentManager.beginTransaction().show(activeFragment).commit()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            if (it.itemId == R.id.recipesFragment){
                supportFragmentManager.beginTransaction().hide(activeFragment).show(recipesFragment).commit()
                activeFragment = recipesFragment
            }else if (it.itemId == R.id.favoriteRecipesFragment){
                supportFragmentManager.beginTransaction().hide(activeFragment).show(favoriteRecipesFragment).commit()
                activeFragment = favoriteRecipesFragment
            }else if (it.itemId == R.id.foodJockerFragment){
                supportFragmentManager.beginTransaction().hide(activeFragment).show(foodJokeFragment).commit()
                activeFragment = foodJokeFragment
            }
            return@setOnNavigationItemSelectedListener true
        }

    }

}