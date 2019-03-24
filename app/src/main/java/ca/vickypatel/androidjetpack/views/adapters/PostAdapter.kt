package ca.vickypatel.androidjetpack.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.vickypatel.androidjetpack.R
import ca.vickypatel.androidjetpack.data.Post
import kotlinx.android.synthetic.main.post_item.view.*

class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var postList: List<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.post_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.postId?.text = postList[position].id.toString()
        holder?.postTitle?.text = postList[position].title
        holder?.postBody?.text = postList[position].body
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    fun updateData(pList: List<Post>) {
        postList = pList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postId = itemView.tv_id
        val postTitle = itemView.tv_post_title
        val postBody = itemView.tv_post_body
    }


}