package com.symetry.mailrequestshugar2.di

import com.symetry.mailrequestshugar2.data.EmailService
import com.symetry.mailvalidator.di.AppModule
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun getEmailService(): EmailService
}
