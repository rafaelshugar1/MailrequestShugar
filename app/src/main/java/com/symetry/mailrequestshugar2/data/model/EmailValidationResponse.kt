package com.symetry.mailrequestshugar.data.model

import com.symetry.mailrequestshugar.data.EmailService

class EmailValidationUseCase(private val emailService: EmailService) {
    suspend fun validateEmail(email: String): Boolean {
        val response = emailService.validateEmail(email)
        return response.isSuccessful && response.body()?.isValid == true
    }
}
