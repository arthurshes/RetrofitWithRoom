package com.example.offlinecacheretrohilt.features.UserAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.offlinecacheretrohilt.db.Restoran
import com.example.offlinecacheretrohilt.databinding.ItemBinding

class UserAdapter:RecyclerView.Adapter<UserAdapter.ViewHolder>(){


    class ViewHolder(private val binding: ItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(user: Restoran){
            binding.apply {
                textAdress.text=user.address
                textKitchen.text=user.name
                txtMagName.text=user.type
                Glide.with(itemView).load(user.logo).into(imageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


            holder.bind(differ.currentList.get(position))

    }

//    class UserDiffUtil:DiffUtil.ItemCallback<Restoran>(){
//        override fun areItemsTheSame(oldItem: Restoran, newItem:Restoran): Boolean {
//            return oldItem.name==newItem.name
//        }
//
//        override fun areContentsTheSame(oldItem: Restoran, newItem: Restoran): Boolean {
//     return oldItem==newItem
//        }
//
//    }

    private val differCallback = object : DiffUtil.ItemCallback<Restoran>() {
        override fun areItemsTheSame(oldItem: Restoran, newItem: Restoran): Boolean {
            return oldItem.id== newItem.id
        }

        override fun areContentsTheSame(oldItem: Restoran, newItem: Restoran): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}