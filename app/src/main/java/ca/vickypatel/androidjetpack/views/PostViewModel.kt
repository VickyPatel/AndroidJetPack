package ca.vickypatel.androidjetpack.views

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import ca.vickypatel.androidjetpack.data.Post
import ca.vickypatel.androidjetpack.data.PostRepository

class PostViewModel(application: Application) : AndroidViewModel(application) {

    private val postRepository : PostRepository
    private val postList : LiveData<List<Post>>

    init {
        postRepository = PostRepository(application)
        postList = postRepository.getAllPosts()
    }

    fun getAllPosts() : LiveData<List<Post>> {
        return postList
    }

    fun addPost(post: Post) {
        postRepository.addPost(post)
    }

    fun deleteAllPost() {
        postRepository.deleteAllPost()
    }



}