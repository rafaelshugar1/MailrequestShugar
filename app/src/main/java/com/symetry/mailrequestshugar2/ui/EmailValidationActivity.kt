package com.symetry.mailvalidator.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.symetry.mailrequestshugar2.R
import com.symetry.mailrequestshugar2.MainActivity
import com.symetry.mailrequestshugar2.data.EmailService
import com.symetry.mailrequestshugar2.domain.EmailValidationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EmailValidationActivity : AppCompatActivity() {
    private lateinit var emailValidationUseCase: EmailValidationUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_validation)

        val retrofit = (application as MainActivity).retrofit
        val emailService = retrofit.create(EmailService::class.java)
        emailValidationUseCase = EmailValidationUseCase(emailService)

        val buttonValidate = findViewById<Button>(R.id.buttonValidate)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonValidate.setOnClickListener {
            val email = editTextEmail.text.toString()
            validateEmail(email)
        }
    }

    private fun validateEmail(email: String) {
        GlobalScope.launch(Dispatchers.Main) {
            val isValid = emailValidationUseCase.validateEmail(email)
            val resultText = if (isValid) "Email válido" else "Email inválido"
            textViewResult.text = resultText
        }
    }
}
