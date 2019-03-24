package ca.vickypatel.androidjetpack.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ca.vickypatel.androidjetpack.data.Post

@Dao
interface PostDao {

    @Query("SELECT * from Post")
    fun getAllPosts() : LiveData<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPost(post: Post)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPosts(posts: List<Post>)

    @Query("SELECT * from Post where id = :id")
    fun getPostById(id : Int) : Post

    @Query("DELETE from Post where id = :id")
    fun deletePostById(id : Int)

    @Query("DELETE from Post")
    fun deleteAllPosts()

}