package com.mandeep.paging_with_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Dao
import com.mandeep.paging_with_room.MVVM.MainRepositry
import com.mandeep.paging_with_room.MVVM.MyViewModel
import com.mandeep.paging_with_room.Room.DaoService
import com.mandeep.paging_with_room.Room.Item
import com.mandeep.paging_with_room.Room.MyRoom
import com.mandeep.paging_with_room.databinding.ActivityMainBinding
import com.mandeep.paging_with_room.paging.MyPagingDataAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var mainRepositry: MainRepositry

    lateinit var  myPagingDataAdapter:MyPagingDataAdapter

     val myViewModel :MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


         myPagingDataAdapter = MyPagingDataAdapter(this)

        //getting all items from room then again getting all items then again so on
         //showingItemsAll()

        //getting items in limit (load size) with offset(currentpage * loadsie)
          showingItemswith_LIMIT_OFFSET()

      /*  binding.recyclerViewww.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewww.adapter = myPagingDataAdapter*/

     /*   CoroutineScope(Dispatchers.Main).launch {
            for (i in 0..2000) {
                mainRepositry.insertItem(Item("Mandeep  $i"))
            }
        }*/

    }

    fun showingItemsAll(){
          lifecycleScope.launch {
              myViewModel.listAllData.collect {
                  myPagingDataAdapter.submitData(it)
              }
          }
        binding.recyclerViewww.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewww.adapter = myPagingDataAdapter
    }

    fun showingItemswith_LIMIT_OFFSET(){
        lifecycleScope.launch {
            myViewModel.listDataWithOffsetData.collect {
                myPagingDataAdapter.submitData(it)
            }
        }
        binding.recyclerViewww.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewww.adapter = myPagingDataAdapter
    }
}