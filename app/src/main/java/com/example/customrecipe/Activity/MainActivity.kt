package com.example.customrecipe.Activity

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.customrecipe.Fragment.CartFragment
import com.example.customrecipe.Fragment.HomeFragment
import com.example.customrecipe.Fragment.ListFragment
import com.example.customrecipe.Fragment.RecipesFragment
import com.example.customrecipe.Fragment.StopFragment
import com.example.customrecipe.R
import com.example.customrecipe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val HomeFragment = HomeFragment()
        val ListFragment = ListFragment()
        val StopFragment = StopFragment()
        val RecipesFragment = RecipesFragment()
        val CartFragment = CartFragment()

        setCurrentFragment(HomeFragment)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(HomeFragment)
                R.id.list->setCurrentFragment(ListFragment)
                R.id.stop->setCurrentFragment(StopFragment)
                R.id.Recipes->setCurrentFragment(RecipesFragment)
                R.id.Cart->setCurrentFragment(CartFragment)

            }
            true
        }
        // window.statusBarColor = ContextCompat.getColor(this, R.color.gradient_background)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val gradientDrawable = GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                intArrayOf(
                    ContextCompat.getColor(this, R.color.green),
                    ContextCompat.getColor(this, R.color.yellow1),
                    ContextCompat.getColor(this, R.color.yellow2)
                )
            )
            window.statusBarColor = Color.TRANSPARENT
            window.setBackgroundDrawable(gradientDrawable)
        }
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
}