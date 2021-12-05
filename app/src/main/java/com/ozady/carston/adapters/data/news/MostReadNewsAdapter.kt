package com.ozady.carston.adapters.data.news

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozady.carston.R
import com.ozady.carston.views.news_reviews.ViewNewsDetailsActivity

class MostReadNewsAdapter   (private val context: Context?) : RecyclerView.Adapter<MostReadNewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_news_mostread, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            context?.startActivity(Intent(context, ViewNewsDetailsActivity::class.java))
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
        ///var imgItem: ImageView =itemView.findViewById(R.id.imgItem)
    }
}