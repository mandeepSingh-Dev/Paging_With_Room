package com.mandeep.paging_with_room.Room

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Entity(tableName = "Item")
data class Item(

    @ColumnInfo(name="name")
    var name:String)
{
    @PrimaryKey(autoGenerate = true)
    var id = 0
}