package com.lovisgod.movemate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MoveMateApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}