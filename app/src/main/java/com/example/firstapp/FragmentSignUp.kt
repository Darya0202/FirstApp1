package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapp.databinding.FragmentSignUpBinding

class FragmentSignUp : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        val signIn : TextView = binding.signIn

        signIn.setOnClickListener {
            val intent = Intent(requireContext(), SignInActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val email: EditText = binding.email
        val password: EditText = binding.password
        val password2: EditText = binding.password2
        val button: Button = binding.buttonSign

        button.setOnClickListener{
            if(email.text.toString().isEmpty() || !email.text.contains("@")){
                Toast.makeText(requireContext(), "Проверьте email", Toast.LENGTH_LONG).show()
            }
            else if(password.text.toString().isEmpty() || password.text.toString().length < 6){
                Toast.makeText(requireContext(), "Пароль должен содержать более 5 символов", Toast.LENGTH_LONG).show()
            }
            else if(password2.text.toString()!=password.text.toString()){
                Toast.makeText(requireContext(), "Пароли не совпадают", Toast.LENGTH_LONG).show()
            }
            else{
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, FragmentMainScreen())
                    .commit()
            }
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}