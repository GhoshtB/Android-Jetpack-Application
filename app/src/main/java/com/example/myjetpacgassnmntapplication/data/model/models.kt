package com.example.myjetpacgassnmntapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity/*(tableName = "itemdata")*/
data class ItemData( var name:String, var qty:String, var rate:String, var amount:String){
    @PrimaryKey(autoGenerate = true) var id:Int=0
    constructor( ):this("", "", "", ""){

    }
}