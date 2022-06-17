package com.mandeep.paging_with_room.paging

import android.content.ClipData
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mandeep.paging_with_room.R
import com.mandeep.paging_with_room.Room.Item
import hilt_aggregated_deps._com_mandeep_paging_with_room_MVVM_MyViewModel_HiltModules_BindsModule

class MyPagingDataAdapter(val context:Context):PagingDataAdapter<Item,MyPagingDataAdapter.MyViewHolder>(diffCallback = diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return MyViewHolder(view)

    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = getItem(position)

        holder.nameTextVIew.text = item?.name
        holder.idTextView.text = item?.id.toString()

        Log.d("Hello",item?.id.toString()+"   "+item?.name)
    }



    class MyViewHolder(var itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val nameTextVIew:TextView  = itemView.findViewById(R.id.nametextView)
        val idTextView:TextView = itemView.findViewById(R.id.idtextView)
    }

    object diffUtil :DiffUtil.ItemCallback<Item>(){
        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
          return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
           return oldItem == newItem
        }
    }

}