package com.ozady.carston.adapters.data.ads

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.ozady.carston.R

class AdsPackageAdapter  (private val context: Context?) : RecyclerView.Adapter<AdsPackageAdapter.ViewHolder>() {

    var selected = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_adpackage, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {

            isSelect.isChecked = selected == position

            itemView.setOnClickListener {
                if (selected != position){
                    isSelect.isChecked = true
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
        ////var imgItem: ImageView =itemView.findViewById(R.id.imgItem)
        var isSelect: RadioButton =itemView.findViewById(R.id.isSelect)
    }
}