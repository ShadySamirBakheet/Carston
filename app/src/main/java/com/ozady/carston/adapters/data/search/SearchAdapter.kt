package com.ozady.carston.adapters.data.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ozady.carston.R

class SearchAdapter(private val context: Context?, val isFav: Boolean) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_search , parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            imageList.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
                adapter = ImageItemSearchAdapter(context)
            }

            if (isFav){
                itemFav.setImageResource(R.drawable.ic_heart)
                itemFav.setColorFilter(ContextCompat.getColor(context!!, R.color.btnColor1))
            }else{
                itemFav.setImageResource(R.drawable.ic_heart_outline)
                itemFav.setColorFilter(ContextCompat.getColor(context!!, R.color.black))
            }

            itemFav.setOnClickListener {
                itemFav.setImageResource(R.drawable.ic_heart)
                itemFav.setColorFilter(ContextCompat.getColor(context!!, R.color.btnColor1))
            }


        }
    }


    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }


    override fun getItemCount(): Int {
        return 8
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageList: RecyclerView = itemView.findViewById(R.id.imageList)
        val itemFav: ImageView = itemView.findViewById(R.id.itemFav)
    }
}