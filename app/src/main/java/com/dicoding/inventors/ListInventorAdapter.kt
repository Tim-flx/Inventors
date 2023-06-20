package com.dicoding.inventors

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListInventorAdapter(private val listInventor: ArrayList<Inventor>) : RecyclerView.Adapter<ListInventorAdapter.ListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_inventor, parent, false)
        return ListViewHolder(view)
    }
    override fun getItemCount(): Int = listInventor.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listInventor[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_inventor", listInventor[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}