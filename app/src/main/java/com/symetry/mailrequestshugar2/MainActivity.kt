package com.symetry.mailrequestshugar2

import android.app.Application
import com.symetry.mailrequestshugar2.di.AppComponent

class MainActivity : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
    }
}