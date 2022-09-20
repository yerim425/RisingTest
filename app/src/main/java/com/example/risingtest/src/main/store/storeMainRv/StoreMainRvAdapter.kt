package com.example.risingtest.src.main.store.storeMainRv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.risingtest.databinding.ItemRvStoreMainBinding
import com.example.risingtest.src.main.store.storeMainRv.storeSecondRv.StoreProductRvGridAdapter
import com.example.risingtest.src.main.store.storeMainRv.storeSecondRv.StoreProductRvLinearAdapter

class StoreMainRvAdapter(val context: Context): RecyclerView.Adapter<StoreMainRvAdapter.ViewHolder>() {

    var list = mutableListOf<StoreMainRvItemData>()

    inner class ViewHolder(val binding: ItemRvStoreMainBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: StoreMainRvItemData){
            binding.tvTitle.setText(item.title)
            if(item.showSeeMoreView){
                binding.tvSeeMore.visibility = View.VISIBLE
            }else binding.tvSeeMore.visibility = View.INVISIBLE


            if(item.viewType == "LH"){ // LinearLayout  Horizontal
                binding.rvStoreProduct.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.rvStoreProduct.adapter = item.produceList?.let { StoreProductRvLinearAdapter(it, context) }
            }else{ // GridLayout
                binding.rvStoreProduct.layoutManager = GridLayoutManager(context, 2)
                binding.rvStoreProduct.adapter = item.produceList?.let {StoreProductRvGridAdapter(it, context) }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRvStoreMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getListFromView(nList: MutableList<StoreMainRvItemData>){
        list = nList
    }
}