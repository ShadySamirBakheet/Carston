package com.ozady.carston.adapters.data.date

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozady.carston.R
import com.ozady.carston.adapters.data.ads.AdsPackageAdapter

class SelectTimeAdapter (private val context: Context?) : RecyclerView.Adapter<SelectTimeAdapter.ViewHolder>() {

    var selected = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_time , parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
///
        holder.apply {

            if (position == selected){
                timeSel.setBackgroundResource(R.drawable.btnblack4)
                if (context != null) {
                    timeSel.setTextColor(context.getColor(R.color.txtColor2))
                }
            }else{
                timeSel.setBackgroundResource(R.drawable.btnborder2)
                if (context != null) {
                    timeSel.setTextColor(context.getColor(R.color.txtColor1))
                }
            }

            timeSel.setOnClickListener {
                if (selected != position){
                    timeSel.setBackgroundResource(R.drawable.btnblack4)
                    if (context != null) {
                        timeSel.setTextColor(context.getColor(R.color.txtColor2))
                    }
                    selected = position
                    notifyDataSetChanged()
                }else{
                    selected = -1
                    notifyDataSetChanged()
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
        var timeSel: TextView =itemView.findViewById(R.id.timeSel)
    }
}