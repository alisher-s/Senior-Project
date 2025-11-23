package com.example.seniorproject

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.emailEditText)
        val password = findViewById<EditText>(R.id.passwordEditText)
        val showPassword = findViewById<CheckBox>(R.id.showPasswordCheck)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val register = findViewById<TextView>(R.id.registration)

        showPassword.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                password.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                password.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            password.setSelection(password.text.length)
        }

        loginButton.setOnClickListener {
            val emailText = email.text.toString().trim()
            val passText = password.text.toString().trim()

//            if (!emailText.endsWith("@nu.edu.kz")) {
//                email.error = "Email must end with @nu.edu.kz"
//                return@setOnClickListener
//            }

            if(emailText == "alisher" && passText == "123") {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, EventsActivity::class.java)
                startActivity(intent)

            }
        }
        register.setOnClickListener{
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
