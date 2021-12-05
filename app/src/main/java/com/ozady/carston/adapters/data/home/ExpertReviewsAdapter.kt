package com.ozady.carston.adapters.data.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ozady.carston.R
import com.ozady.carston.views.cars.CarViewActivity

class ExpertReviewsAdapter  (private val context: Context?) : RecyclerView.Adapter<ExpertReviewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_expart_cars , parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.apply {
            itemView.setOnClickListener {
                context?.startActivity(Intent(context, CarViewActivity::class.java))
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
    }
}
