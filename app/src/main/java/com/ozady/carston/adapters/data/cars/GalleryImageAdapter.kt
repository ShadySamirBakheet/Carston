package com.ozady.carston.adapters.data.cars

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ozady.carston.R

class GalleryImageAdapter (private val context: Context?) : RecyclerView.Adapter<GalleryImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_car_img , parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            when(position){
                0->imgItem.setImageResource(R.drawable.image1)
                1->imgItem.setImageResource(R.drawable.image2)
                2->imgItem.setImageResource(R.drawable.image4)
                3->imgItem.setImageResource(R.drawable.image5)
                4->imgItem.setImageResource(R.drawable.image6)
                5->imgItem.setImageResource(R.drawable.image7)
                6->imgItem.setImageResource(R.drawable.image8)
                7->imgItem.setImageResource(R.drawable.image9)
                8->imgItem.setImageResource(R.drawable.image10)
            }
        }
    }


    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }


    override fun getItemCount(): Int {
        return 9
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgItem: ImageView =itemView.findViewById(R.id.imgItem)
    }
}
