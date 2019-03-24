package ca.vickypatel.androidjetpack.views

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import ca.vickypatel.androidjetpack.R
import ca.vickypatel.androidjetpack.data.Post
import kotlinx.android.synthetic.main.add_post_dialog.view.*

class AddPostDialog : DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        val view  = inflater!!.inflate(R.layout.add_post_dialog, container, false)

        view.btn_add.setOnClickListener({
            val postTitle = view.et_post_title.text.toString()
            if (TextUtils.isEmpty(postTitle)) {
                Toast.makeText(activity, "Please enter Title first", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val postBody = view.et_post_body.text.toString()
            if (TextUtils.isEmpty(postBody)) {
                Toast.makeText(activity, "Please enter Body first", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var post = Post()
            post.title = postTitle
            post.body = postBody
            getPostViewModel()?.addPost(post)

            // clear texts
            view.et_post_title.text.clear()
            view.et_post_body.text.clear()
        })

        return view
    }

    private fun getPostViewModel(): PostViewModel? {
        if (activity is MainActivity) {
            return (activity as MainActivity).getPostViewModel()
        }
        return  null
    }


    override fun onStart() {
        super.onStart()
        dialog.window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    companion object {
        fun newInstance() : AddPostDialog {
            return AddPostDialog()
        }
    }


}