package com.example.myjetpacgassnmntapplication.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myjetpacgassnmntapplication.data.model.ItemData

@Database(entities = arrayOf(ItemData::class),version = 1,exportSchema = false)
abstract class ItemDataDb:RoomDatabase() {

abstract fun itemDataDao():ItemDataDao



/*companion object{
    private var INSTANCE:ItemDataDb? =null
    fun getInstance(application: Application):ItemDataDb{
if (INSTANCE==null){
    INSTANCE= Room.databaseBuilder(application.applicationContext,ItemDataDb::class.java,"item.db").build()

}

        return INSTANCE!!
    }
}*/

}