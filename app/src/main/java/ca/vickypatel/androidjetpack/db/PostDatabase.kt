package ca.vickypatel.androidjetpack.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ca.vickypatel.androidjetpack.data.Post


@Database(entities = [Post::class], version = 1)
abstract class PostDatabase : RoomDatabase() {

    abstract fun postDao() : PostDao

    companion object {

        private val lock = Any()
        private val DB_NAME = "Post.db"
        private var INSTANCE: PostDatabase? = null

        fun getInstance(application: Application): PostDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(application, PostDatabase::class.java, DB_NAME)
                            .allowMainThreadQueries()
                            .build()
                }
                return INSTANCE!!
            }
        }

    }


}