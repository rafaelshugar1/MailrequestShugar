package com.symetry.mailrequestshugar2

import android.app.Application
import com.symetry.mailrequestshugar2.di.AppComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        //ppComponent = DaggerAppComponent
    }
}