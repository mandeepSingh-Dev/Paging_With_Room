package com.mandeep.paging_with_room.paging

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mandeep.paging_with_room.MVVM.MainRepositry
import com.mandeep.paging_with_room.Room.Item
import java.lang.Exception
import javax.inject.Inject

class MyPagingSource @Inject constructor(val mainRepositry: MainRepositry):PagingSource<Int, Item>()
{
    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {

        try {
            Log.d("3r9f3jf",params.loadSize.toString())
            val currentKey = params.key ?:1

            val itemList = mainRepositry.queryItems()

        val prevKey = if(currentKey == 1) null else currentKey-1
        val nextKey = if(itemList.isEmpty()) null else currentKey+1

            Log.d("49tj4f",currentKey.toString()+"   CURRENTKEY")
            Log.d("49tj4f",prevKey.toString()+"   CURRENTKEY")
            Log.d("49tj4f",nextKey.toString()+"   nextKey")

        val page = LoadResult.Page(data = itemList, prevKey = prevKey, nextKey = nextKey)
        return page
        }catch (e: Exception){
            return LoadResult.Error(e)
        }
    }


}