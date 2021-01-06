package com.example.myjetpacgassnmntapplication.data.repos

import com.example.myjetpacgassnmntapplication.data.db.ItemDataDao
import com.example.myjetpacgassnmntapplication.data.model.ItemData
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class ItemRepositoryImpl constructor(val itemDataDao: ItemDataDao):ItemRepository,CoroutineScope {
    override suspend fun insertItem(data: ItemData) {
coroutineScope {
    itemDataDao.insertItem(data)
}
    }

    override suspend fun getItemData(): List<ItemData> {

return GlobalScope.async {itemDataDao.getItems()  }.await()

    }

    override fun deleteItem(data: ItemData) {
        launch (context = Dispatchers.IO){
//            itemDataDao.deleteByUserId(data.id.toLong())
            itemDataDao.deleteItem(data)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO
}