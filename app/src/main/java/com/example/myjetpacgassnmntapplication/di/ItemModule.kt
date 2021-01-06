package com.example.myjetpacgassnmntapplication.di

import com.example.myjetpacgassnmntapplication.data.db.ItemDataDao
import com.example.myjetpacgassnmntapplication.data.repos.ItemRepository
import com.example.myjetpacgassnmntapplication.data.repos.ItemRepositoryImpl
import com.example.myjetpacgassnmntapplication.viewmodel.ItemListViewmodel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val itemmodule = module {

    viewModel {
//        single<ItemRepository> { ItemRepositoryImpl(get()) }
        ItemListViewmodel(get<ItemRepository>())
//        AddItemViewmodel(get<ItemRepository>())
    }
}

val repositoryModule = module {

    fun provideRepository(dao: ItemDataDao):ItemRepository{
        return ItemRepositoryImpl(dao)
    }
    single { provideRepository(get()) }

}