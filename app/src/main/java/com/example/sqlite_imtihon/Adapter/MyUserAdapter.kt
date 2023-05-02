package com.example.sqlite_imtihon.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlite_imtihon.databinding.ItemRvBinding
import com.example.sqlite_imtihon.models.User

class MyUserAdapter(val list: ArrayList<User>):RecyclerView.Adapter<MyUserAdapter.VH>() {
    inner class VH(var itemRv: ItemRvBinding) :
        RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(user: User, position: Int) {
            itemRv.rvTvText1.text = user.name
            itemRv.rvTvText2.text = user.date


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position], position)
    }


    override fun getItemCount(): Int = list.size

}