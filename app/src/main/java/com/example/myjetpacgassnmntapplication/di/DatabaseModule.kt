package com.example.myjetpacgassnmntapplication.di

import android.app.Application
import androidx.room.Room
import com.example.myjetpacgassnmntapplication.data.db.ItemDataDao
import com.example.myjetpacgassnmntapplication.data.db.ItemDataDb
import com.example.myjetpacgassnmntapplication.data.repos.ItemRepository
import com.example.myjetpacgassnmntapplication.data.repos.ItemRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
//    single { ItemDataDb.getInstance(get()) }
//    single { get<ItemDataDb>().itemDataDao() }

    fun provideDatabase(application: Application): ItemDataDb {
        return Room.databaseBuilder(application, ItemDataDb::class.java, "item.db")
//            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideCountriesDao(dataDb: ItemDataDb): ItemDataDao {
        return  dataDb.itemDataDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideCountriesDao(get()) }

}