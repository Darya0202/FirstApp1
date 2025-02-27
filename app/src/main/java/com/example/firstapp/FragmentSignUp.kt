package com.example.firstapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.firstapp.databinding.FragmentSignUpBinding


class FragmentSignUp : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        binding.signIn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentSignUp())
                .addToBackStack(null)
                .commit()
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonSign.setOnClickListener{
            if(binding.email.text.toString().isEmpty() || !binding.email.text.contains("@")){
                Toast.makeText(requireContext(), "Проверьте email", Toast.LENGTH_LONG).show()
            }
            else if(binding.password.text.toString().isEmpty() || binding.password.text.toString().length < 6){
                Toast.makeText(requireContext(), "Пароль должен содержать более 5 символов", Toast.LENGTH_LONG).show()
            }
            else if(binding.password2.text.toString()!=binding.password.text.toString()){
                Toast.makeText(requireContext(), "Пароли не совпадают", Toast.LENGTH_LONG).show()
            }
            else{
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, FragmentMainScreen())
                    .commit()

                val sharedPref = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                val emailText = binding.email.text.toString()

                editor.putString("saved_email", emailText)
                editor.apply()
            }
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}