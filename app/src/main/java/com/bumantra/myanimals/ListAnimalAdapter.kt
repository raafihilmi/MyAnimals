package com.bumantra.myanimals

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumantra.myanimals.databinding.ItemRecyclerviewRowBinding
import com.bumptech.glide.Glide

class ListAnimalAdapter (private val listAnimal: ArrayList<Animal>): RecyclerView.Adapter <ListAnimalAdapter.ListViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): ListViewHolder {
        val binding = ItemRecyclerviewRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listAnimal[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgAnimal)
        holder.binding.tvAnimal.text = name
        holder.binding.tvDescription.text = description.substringBefore('.')
        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_animal", listAnimal[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listAnimal.size

    class ListViewHolder(var binding: ItemRecyclerviewRowBinding) : RecyclerView.ViewHolder(binding.root)
}