package com.symetry.mailvalidator.data.model

import com.symetry.mailvalidator.data.EmailService

class EmailValidationUseCase(private val emailService: EmailService) {
    suspend fun validateEmail(email: String): Boolean {
        val response = emailService.validateEmail(email)
        return response.isSuccessful && response.body()?.isValid == true
    }
}
