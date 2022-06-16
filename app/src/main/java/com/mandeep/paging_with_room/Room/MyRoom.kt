package com.mandeep.paging_with_room.Room
import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room


@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class MyRoom:RoomDatabase(){
/*companion object {
    val lock = Any()
    var myRoom: MyRoom? = null
    val databaseName = "Paging_with_Room"

    fun getRoomInstance(context: Context): MyRoom? {
        if (myRoom == null) {
            synchronized(lock)
            {
                myRoom = Room.databaseBuilder(context, MyRoom::class.java, databaseName).build()
            }
        }
        return myRoom
    }
}*/

        abstract fun getDaoService(): DaoService

}
