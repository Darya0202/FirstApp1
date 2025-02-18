package com.example.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.firstapp.databinding.FragmentMainScreenBinding
import com.example.firstapp.databinding.FragmentProfileBinding

class FragmentMainScreen : Fragment() {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        loadFragment(FragmentHome())
        binding.bottomNav.selectedItemId = R.id.item_home

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

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Оставляем пустым, чтобы отключить поведение кнопки "Назад"
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun loadFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}