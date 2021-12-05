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
import com.ozady.carston.views.cars.CarBrandListActivity

class BrandAdapter(private val context: Context?, val isHome: Boolean): RecyclerView.Adapter<BrandAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v: View = inflater.inflate(if(isHome)R.layout.item_brand else R.layout.item_brand2, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.apply {

            when(position % 6){
                0 -> {
                    nameItem.text = "Toyota"
                    image.setImageResource(R.drawable.ic_car_toyota)
                }
                1 -> {
                    nameItem.text = "BMW"
                    image.setImageResource(R.drawable.ic_car_bmw)
                }
                2 -> {
                    nameItem.text = "Jeep"
                     image.setImageResource(R.drawable.ic_car_jeep)
                }
                3 -> {
                    nameItem.text = "Peugeot"
                    image.setImageResource(R.drawable.ic_car_peugeot)
                }
                4 -> {
                    nameItem.text = "Acura"
                    image.setImageResource(R.drawable.ic_car_acura)
                }
                5 -> {
                    nameItem.text = "KIA"
                    image.setImageResource(R.drawable.ic_car_kia)
                }
            }

            itemView.setOnClickListener {
                context?.startActivity(Intent(context, CarBrandListActivity::class.java))
            }
        }

    }

    override fun getItemCount(): Int {
        return 8
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val nameItem: TextView = itemView.findViewById(R.id.nameItem)
    }

}
