package ca.vickypatel.androidjetpack.network

import ca.vickypatel.androidjetpack.data.Post
import retrofit2.Call
import retrofit2.http.GET

interface WebService {

    @GET("/posts")
    fun getPosts() : Call<List<Post>>

}