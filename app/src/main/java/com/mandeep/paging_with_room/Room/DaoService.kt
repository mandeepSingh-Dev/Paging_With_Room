package com.mandeep.paging_with_room.Room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoService {

    @Insert
    suspend fun insert(item:Item):Long

    @Query("SELECT * FROM Item ")
    suspend fun queryItems():List<Item>

    @Query("SELECT * FROM ITEM LIMIT :size OFFSET :offset")
    suspend fun queryItemsWithOffset(size:Int, offset:Int):List<Item>
}