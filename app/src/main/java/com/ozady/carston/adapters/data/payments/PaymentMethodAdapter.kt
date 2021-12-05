package com.ozady.carston.adapters.data.payments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozady.carston.R

class PaymentMethodAdapter(private val context: Context?) : RecyclerView.Adapter<PaymentMethodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_payment , parent, false)
        return ViewHolder(view)
    }

    var selected = -1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.apply {

            when(position){
                0->{
                    imgItem.setImageResource(R.drawable.ic_paypal)
                    nameItem.text = "PayPal"
                }
                1->{
                    imgItem.setImageResource(R.drawable.ic_fawry)
                    nameItem.text = "Fawry"
                }
                2->{
                    imgItem.setImageResource(R.drawable.ic_money)
                    nameItem.text = "Cash"
                }
            }

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
        return 3
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgItem: ImageView =itemView.findViewById(R.id.imgItem)
        var nameItem: TextView =itemView.findViewById(R.id.nameItem)
        var isSelect: RadioButton =itemView.findViewById(R.id.isSelect)
    }
}