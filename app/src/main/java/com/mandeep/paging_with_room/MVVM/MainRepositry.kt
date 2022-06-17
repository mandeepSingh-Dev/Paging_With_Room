package com.mandeep.paging_with_room.MVVM

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.mandeep.paging_with_room.Room.DaoService
import com.mandeep.paging_with_room.Room.Item
import javax.inject.Inject

class MainRepositry  @Inject constructor(val daoService: DaoService) {


    suspend fun queryItems():List<Item> = daoService.queryItems()

    suspend fun queryItemsWithOffset(size:Int, offset:Int):List<Item> = daoService.queryItemsWithOffset(size,offset)


    suspend fun insertItem(item:Item)
    {
        daoService.insert(item)
    }
}