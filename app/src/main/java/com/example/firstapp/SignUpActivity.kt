package com.example.firstapp

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

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        var signIn : TextView = findViewById(R.id.signIn)

        signIn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var email:EditText = findViewById(R.id.email)
        var password:EditText = findViewById(R.id.password)
        var password2:EditText = findViewById(R.id.password2)
        var button:Button = findViewById(R.id.buttonSign)

        button.setOnClickListener{
            if(email.text.toString().isEmpty() || !email.text.contains("@")){
                Toast.makeText(this, "Проверьте email", Toast.LENGTH_LONG).show()
            }
            else if(password.text.toString().isEmpty() || password.text.toString().length < 6){
                Toast.makeText(this, "Пароль должен содержать более 5 символов", Toast.LENGTH_LONG).show()
            }
            else if(password2.text.toString()!=password.text.toString()){
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_LONG).show()
            }
            else{
                var intent = Intent(this, MainActivity_Home::class.java)
                startActivity(intent)
            }
        }

    }
}