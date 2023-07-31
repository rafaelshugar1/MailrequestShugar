package com.symetry.mailrequestshugar2

import android.app.Application
import com.symetry.mailrequestshugar2.di.AppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
    }
}