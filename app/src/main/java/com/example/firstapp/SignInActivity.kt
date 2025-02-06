package com.example.firstapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    private var _binding: ActivitySignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val signUp : TextView = binding.signUp

        signUp.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentSignUp())
                .addToBackStack(null)
                .commit()
        }

        val email: EditText = binding.email
        val password: EditText = binding.password
        val button: Button = binding.buttonSign

        button.setOnClickListener{
                if(email.text.toString().isEmpty() || !email.text.contains("@")){
                    Toast.makeText(this, "Проверьте email", Toast.LENGTH_LONG).show()
                }
                else if(password.text.toString().isEmpty() || password.text.length < 6){
                    Toast.makeText(this, "Пароль должен содержать более 5 символов", Toast.LENGTH_LONG).show()
                }
                else{
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, FragmentMainScreen())
                        .commit()

                    val sharedPref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    val emailText = email.text.toString()

                    editor.putString("saved_email", emailText)
                    editor.apply()
                }
            }
        }
    }
