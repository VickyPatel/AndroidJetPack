package ca.vickypatel.androidjetpack.data

import android.app.Application
import androidx.lifecycle.LiveData
import ca.vickypatel.androidjetpack.db.PostDao
import ca.vickypatel.androidjetpack.db.PostDatabase
import ca.vickypatel.androidjetpack.network.RetrofitClient
import ca.vickypatel.androidjetpack.network.WebService
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.POST
import javax.security.auth.callback.Callback

class PostRepository(application: Application) {

    private val postDao: PostDao
    private val webService: WebService

    init {
        // database
        val postDatabase = PostDatabase.getInstance(application)
        postDao = postDatabase.postDao()

        // rest API
        webService = RetrofitClient.getInstance().create(WebService::class.java)
    }


    fun getAllPosts(): LiveData<List<Post>> {
        // get posts from server and update local cache
        refreshPosts()

        // simply return data from local cache
        return postDao.getAllPosts()
    }

    fun getPost(id: Int): Post {
        return postDao.getPostById(id)
    }

    fun addPost(post: Post) {
        postDao.addPost(post)
    }

    fun deletePostById(id: Int) {
        postDao.deletePostById(id)
    }

    fun deleteAllPost() {
        postDao.deleteAllPosts()
    }


    private fun refreshPosts() {
        webService.getPosts().enqueue(object : Callback, retrofit2.Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    postDao.addPosts(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                // need to be handled
            }
        })
    }


}