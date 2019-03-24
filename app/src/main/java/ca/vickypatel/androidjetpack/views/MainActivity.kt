package ca.vickypatel.androidjetpack.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import ca.vickypatel.androidjetpack.R
import ca.vickypatel.androidjetpack.data.Post
import ca.vickypatel.androidjetpack.views.adapters.PostAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var postViewModel: PostViewModel
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        postViewModel.getAllPosts().observe(this, Observer { postLists ->
            updateData(postLists)
        })

        postAdapter = PostAdapter()
        post_list.adapter = postAdapter
        post_list.layoutManager = LinearLayoutManager(this)

        btn_add.setOnClickListener({

            val addPostDialog : DialogFragment = AddPostDialog.newInstance()
            addPostDialog.show(supportFragmentManager, AddPostDialog::class.java.simpleName)

        })

        btn_delete.setOnClickListener({
            postViewModel.deleteAllPost()
        })

    }

    private fun updateData(postList: List<Post>) {
        Log.d(TAG, "Update Data called: ${postList.size}")
        postAdapter.updateData(postList)
    }


    public fun getPostViewModel(): PostViewModel {
        return postViewModel
    }


    companion object {
        private val TAG = "MainActivity"
    }

}
