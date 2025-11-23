package com.example.seniorproject

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val email = findViewById<EditText>(R.id.emailEditText)
        val password = findViewById<EditText>(R.id.passwordEditText)
        val showPassword = findViewById<CheckBox>(R.id.showPasswordCheck)
        val registerButton = findViewById<Button>(R.id.registerButton)

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

        registerButton.setOnClickListener {
            val emailText = email.text.toString().trim()
            val passText = password.text.toString().trim()

            if (!emailText.endsWith("@nu.edu.kz")) {
                email.error = "Email must end with @nu.edu.kz"
                return@setOnClickListener
            }

            if (passText.length < 6) {
                password.error = "Password must be at least 6 characters"
                return@setOnClickListener
            }

            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
