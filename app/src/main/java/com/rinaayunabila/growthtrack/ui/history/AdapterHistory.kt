package com.rinaayunabila.growthtrack.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rinaayunabila.growthtrack.R
import com.rinaayunabila.growthtrack.data.DataaItem
import de.hdodenhof.circleimageview.CircleImageView

class AdapterHistory(private val dataList: List<DataaItem?>?) : RecyclerView.Adapter<AdapterHistory.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.namabayi)
        val gambar: CircleImageView = itemView.findViewById(R.id.gambarbayi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dataitem = dataList!![position]
        if (dataitem != null) {
            holder.textView.text = dataitem.babyName
            val gender = dataitem.gender
            if (gender==1) {
                holder.gambar.setImageResource(R.drawable.boy)
            } else {
                holder.gambar.setImageResource(R.drawable.girl)
            }
        }
    }

    override fun getItemCount() = dataList!!.size
}