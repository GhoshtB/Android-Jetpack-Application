package com.example.myjetpacgassnmntapplication.data.repos

import com.example.myjetpacgassnmntapplication.data.model.ItemData
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    suspend fun insertItem(data: ItemData)

    suspend fun getItemData(): List<ItemData>

     fun deleteItem(data: ItemData)
}