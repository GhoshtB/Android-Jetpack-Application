package com.example.myjetpacgassnmntapplication.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.myjetpacgassnmntapplication.data.model.ItemData

@Dao
interface ItemDataDao {

    @Insert(onConflict = REPLACE)
   suspend fun insertItem(data: ItemData)

    @Query("SELECT * FROM itemdata")
   suspend fun getItems(): List<ItemData>

    @Delete
   suspend fun deleteItem(data: ItemData)

    @Query("DELETE FROM itemdata WHERE id = :userId")
   suspend fun deleteByUserId(userId: Long)

//    @Query("DELETE FROM users WHERE user_id = :userId")
}