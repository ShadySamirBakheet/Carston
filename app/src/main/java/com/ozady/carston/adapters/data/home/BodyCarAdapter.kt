package com.ozady.carston.adapters.data.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozady.carston.R
import com.ozady.carston.views.cars.NewCarsActivity

class BodyCarAdapter(
    private val context: Context?,
    private val isHome: Boolean,
    private val isFilter: Boolean
) : RecyclerView.Adapter<BodyCarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(if (isHome)R.layout.item_body_car else R.layout.item_body2 , parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.apply {

            when(position % 6){
                0 -> {
                    nameItem.text = "Toyota"
                    //image.setImageResource(R.drawable.ic_car_toyota)
                }
                1 -> {
                    nameItem.text = "BMW"
                    image.setImageResource(R.drawable.pink_car2)
                }
                2 -> {
                    nameItem.text = "Jeep"
                    image.setImageResource(R.drawable.gray_car)
                }
                3 -> {
                    nameItem.text = "Peugeot"
                    image.setImageResource(R.drawable.pink_car)
                }
                4 -> {
                    nameItem.text = "Acura"
                    image.setImageResource(R.drawable.orange_car)
                }
                5 -> {
                    nameItem.text = "KIA"
                    image.setImageResource(R.drawable.white_car)
                }
            }

            itemView.setOnClickListener {
                if (isFilter){
                    mainCon.setBackgroundResource(R.drawable.round_shape)
                }else{
                    context?.startActivity(Intent(context,NewCarsActivity::class.java))
                }
            }

        }

    }


    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }


    override fun getItemCount(): Int {
        return if (isHome){
            6
        }else{
            60
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mainCon: LinearLayout =itemView.findViewById(R.id.mainCon)
        var nameItem: TextView =itemView.findViewById(R.id.nameItem)
        var image: ImageView =itemView.findViewById(R.id.image)
    }
}
