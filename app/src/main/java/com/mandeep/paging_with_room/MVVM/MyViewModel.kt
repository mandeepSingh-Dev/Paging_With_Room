package com.mandeep.paging_with_room.MVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mandeep.paging_with_room.paging.MyPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(val mainRepositry: MainRepositry):ViewModel() {

    val listAllData = Pager(PagingConfig(pageSize = 10)){
        MyPagingSource(mainRepositry,1)
    }.flow.cachedIn(viewModelScope)

    val listDataWithOffsetData = Pager(PagingConfig(pageSize = 10)){
        MyPagingSource(mainRepositry,2)
    }.flow.cachedIn(viewModelScope)
}