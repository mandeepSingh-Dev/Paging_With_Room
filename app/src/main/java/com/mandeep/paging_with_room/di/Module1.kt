package com.mandeep.paging_with_room.di

import android.content.Context
import androidx.room.Room
import com.mandeep.paging_with_room.Room.DaoService
import com.mandeep.paging_with_room.Room.MyRoom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
class Module1 {

  //  fun getDao(@ApplicationContext context: Context) = Retrofit.Builder().baseUrl()
  val databaseName = "Paging_with_Room"

    @Provides
    fun getDao(@ApplicationContext context:Context) = Room.databaseBuilder(context,MyRoom::class.java,databaseName).fallbackToDestructiveMigration().build().getDaoService()


    lateinit var context:Context
    @Provides
    fun provideContext(@ApplicationContext context: Context):Context
    {
        this.context = context
        return  context
    }

}