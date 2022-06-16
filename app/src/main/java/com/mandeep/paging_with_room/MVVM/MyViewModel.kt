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

    val listData = Pager(PagingConfig(pageSize = 10)){
        MyPagingSource(mainRepositry)
    }.flow.cachedIn(viewModelScope)
}