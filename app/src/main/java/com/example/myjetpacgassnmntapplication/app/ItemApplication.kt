package com.example.myjetpacgassnmntapplication.app

import android.app.Application
import com.example.myjetpacgassnmntapplication.di.databaseModule
import com.example.myjetpacgassnmntapplication.di.itemmodule
import com.example.myjetpacgassnmntapplication.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ItemApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@ItemApplication)
            modules(listOf( databaseModule, repositoryModule, itemmodule))
        }
    }
}