package com.symetry.mailrequestshugar.data


import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

data class EmailValidationResponse(val isValid: Boolean)

interface EmailService {
    @POST("validate_email")
    suspend fun validateEmail(@Body email: String): Response<EmailValidationResponse>
}
