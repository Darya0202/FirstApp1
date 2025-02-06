package com.example.firstapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.firstapp.databinding.FragmentProfileBinding


class FragmentProfile : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.buttonExit.setOnClickListener {
            val intent = Intent(requireContext(), SignInActivity::class.java)
            startActivity(intent)
        }

        /*val emailText2: TextView = binding.emailText
        Log.d("ProfileFragment", "emailText2: $emailText2")

        val sharedPref = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val savedEmail = sharedPref.getString("saved_email", "") // Получаем email
        Log.d("ProfileFragment", "Saved email: $savedEmail")
        emailText2.text = savedEmail
        Log.d("ProfileFragment", "After setting text: ${emailText2.text}")*/



        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emailText2: TextView = binding.emailText
        val sharedPref = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val savedEmail = sharedPref.getString("saved_email", "")

        emailText2.text = savedEmail
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}