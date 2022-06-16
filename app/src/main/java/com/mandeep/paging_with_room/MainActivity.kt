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

     val myViewModel :MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)



        val myPagingDataAdapter = MyPagingDataAdapter(this)

        lifecycleScope.launch {
            myViewModel.listData.collect {
                myPagingDataAdapter.submitData(it)
            }
        }

        binding.recyclerViewww.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewww.adapter = myPagingDataAdapter

       /* CoroutineScope(Dispatchers.Main).launch {
            for (i in 0..49) {
                mainRepositry.insertItem(Item("Mandeep  $i"))
            }
        }*/

    }
}