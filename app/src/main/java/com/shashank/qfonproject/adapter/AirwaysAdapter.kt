package com.shashank.qfonproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.shashank.qfonproject.R
import com.shashank.qfonproject.data.model.Aireways
import com.shashank.qfonproject.data.model.Airline
import com.shashank.qfonproject.data.model.Data

class AirwaysAdapter(var list: List<Data>):
    RecyclerView.Adapter<AirwaysAdapter.AirWaysViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirWaysViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_airways,parent,false)
        return  AirWaysViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: AirWaysViewHolder, position: Int) {
       val data = list[position]
        holder.AireWaysId.text = data._id.toString()
        holder.name.text =data.airline[0].name

        holder.country.text=data.airline[0].country.toString()
       holder.slogan.text = data.airline[0].slogan
        holder.website.text =data.airline[0].website
        holder.trips.text=data.trips.toString()
        holder.txtname.text=   data.name.toString()

        Glide.with(holder.itemView.context)
            .load(data.airline[0].logo)
            .placeholder(R.drawable.test_img)
            .into(holder.image)
    }
    class  AirWaysViewHolder(itemView:View):ViewHolder(itemView){
        val AireWaysId =itemView.findViewById<TextView>(R.id.txtAirwaysId)
        val name =itemView.findViewById<TextView>(R.id.txtAirwaysName)
        val trips =itemView.findViewById<TextView>(R.id.textView3)
        val country =itemView.findViewById<TextView>(R.id.txtCountry)
        val headQ =itemView.findViewById<TextView>(R.id.txtHeadQuater)
        val website = itemView.findViewById<TextView>(R.id.txtWebsite)
        val slogan =itemView.findViewById<TextView>(R.id.txtSlogan)
        val image  =itemView.findViewById<ImageView>(R.id.airwaysImg)
        val txtname = itemView.findViewById<TextView>(R.id.txtname)

    }

}