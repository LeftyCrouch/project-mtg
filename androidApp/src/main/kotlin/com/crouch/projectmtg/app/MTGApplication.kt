package com.crouch.projectmtg.app

import android.app.Application
import com.crouch.projectmtg.shared.app.di.initKoin
import org.koin.android.ext.koin.androidContext

class MTGApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MTGApplication)
        }
    }
}
