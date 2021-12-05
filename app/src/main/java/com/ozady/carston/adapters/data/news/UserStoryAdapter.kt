package com.ozady.carston.adapters.data.news

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozady.carston.R
import com.ozady.carston.views.news_reviews.AddStoryActivity
import com.ozady.carston.views.news_reviews.StoryViewActivity

class UserStoryAdapter (private val context: Context?) : RecyclerView.Adapter<UserStoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_user_story, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.apply {

            if (position == 0){
                imgItem.setImageResource(R.drawable.ic_add)
                nameItem.text = "Add Story"
            }else{
                imgItem.setImageResource(R.drawable.image2)
                nameItem.text = "Shady Samir"
            }

            itemView.setOnClickListener {
                if (position == 0){
                    onItemClickListener.let {
                        if (it != null) {
                            it(0)
                        }
                    }
                }else{
                    context?.startActivity(Intent(context,StoryViewActivity::class.java))
                }
            }
        }

    }


    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }


    override fun getItemCount(): Int {
        return 6
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgItem: ImageView =itemView.findViewById(R.id.imgItem)
        var nameItem: TextView =itemView.findViewById(R.id.nameItem)
    }
}