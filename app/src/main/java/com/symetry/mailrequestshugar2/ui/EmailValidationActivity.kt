package com.symetry.mailvalidator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.symetry.mailrequestshugar2.App
import com.symetry.mailrequestshugar2.R
import com.symetry.mailrequestshugar.data.EmailService
import com.symetry.mailrequestshugar.domain.EmailValidationUseCase
import com.symetry.mailrequestshugar2.databinding.ActivityEmailValidationBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

@AndroidEntryPoint
class EmailValidationActivity : AppCompatActivity() {
    private lateinit var emailValidationUseCase: EmailValidationUseCase
    private lateinit var emailService: EmailService
    private lateinit var binding: ActivityEmailValidationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailValidationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = application as App
        emailService = app.appComponent.getEmailService()
        emailValidationUseCase = EmailValidationUseCase(emailService)

        binding.buttonValidate.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            validateEmail(email)
        }
    }

    private fun validateEmail(email: String) {
        GlobalScope.launch(Dispatchers.Main) {
            val isValid = emailValidationUseCase.validateEmail(email)
            val resultText = if (isValid) getString(R.string.email_valido) else getString(R.string.email_invalido)
            binding.textViewResult.text = resultText
        }
    }
}
