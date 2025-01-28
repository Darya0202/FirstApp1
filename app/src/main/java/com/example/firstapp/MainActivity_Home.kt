package com.example.firstapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firstapp.databinding.ActivityMainHomeBinding

class MainActivity_Home : AppCompatActivity() {
    private var _binding: ActivityMainHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(FragmentHome())
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_home -> {
                    loadFragment(FragmentHome())
                    true
                }
                R.id.item_news -> {
                    loadFragment(FragmentNews())
                    true
                }
                R.id.item_profile -> {
                    loadFragment(FragmentProfile())
                    true
                }
                else -> false
            }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Оставляем пустым, чтобы отключить поведение кнопки "Назад"
            }
        })
    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}