package com.symetry.mailvalidator.di

import com.symetry.mailvalidator.data.EmailService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://shugar.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideEmailService(retrofit: Retrofit): EmailService {
        return retrofit.create(EmailService::class.java)
    }
}
