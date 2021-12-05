package com.ozady.carston.adapters.data.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozady.carston.R
import com.ozady.carston.views.cars.CarViewActivity
import com.ozady.carston.views.cars.ViewCarActivity

class PopularCarAdapter (private val context: Context?) : RecyclerView.Adapter<PopularCarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_popular_car , parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {

            if (position%2 == 0){
                imgItem.setImageResource(R.drawable.image9)
                nameItem.text = "BMW 3 Series Sedan M Automobiles"
            }else{
                imgItem.setImageResource(R.drawable.image4)
                nameItem.text = "BMW 11 Series Sedan "
            }

            itemView.setOnClickListener {
                if (context != null) {
                    context.startActivity(Intent(context, ViewCarActivity::class.java))
                }
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
        var imgItem: ImageView =itemView.findViewById(R.id.imgItem)
        var nameItem: TextView =itemView.findViewById(R.id.nameItem)
    }
}
