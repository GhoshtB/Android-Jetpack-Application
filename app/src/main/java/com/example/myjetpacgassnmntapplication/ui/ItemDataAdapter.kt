package com.example.myjetpacgassnmntapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myjetpacgassnmntapplication.BR
import com.example.myjetpacgassnmntapplication.R
import com.example.myjetpacgassnmntapplication.data.model.ItemData
import com.example.myjetpacgassnmntapplication.databinding.ItemCardRowBinding

class ItemDataAdapter(var list: List<ItemData>,val callback:ItemData.()->Unit) : RecyclerView.Adapter<ItemDataAdapter.ItemDataHolder>() {

    lateinit var binding: ItemCardRowBinding
//    lateinit var list: List<ItemData>

    inner class ItemDataHolder(val binding: ItemCardRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binds(itemData: ItemData) {
            binding.setVariable(BR.item, itemData)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDataHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_card_row, parent, false)
        return ItemDataHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemDataHolder, position: Int) {
        holder.apply { binds(list[position])
            holder.binding.ivDelete.setOnClickListener { callback(list[position]) }}
    }


    override fun getItemCount(): Int {
        return list.size
    }
}