package com.symetry.mailvalidator.di

import com.symetry.mailvalidator.data.EmailService
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun getEmailService(): EmailService
}
