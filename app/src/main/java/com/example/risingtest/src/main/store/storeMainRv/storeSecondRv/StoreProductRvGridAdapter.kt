package com.example.risingtest.src.main.store.storeMainRv.storeSecondRv

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.risingtest.R
import com.example.risingtest.databinding.ItemRvProductBaseBinding

class StoreProductRvGridAdapter(var prodList: MutableList<ProductItemData>, val context: Context)
    : RecyclerView.Adapter<StoreProductRvGridAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemRvProductBaseBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: ProductItemData){

            Glide.with(binding.ivProdImg)
                .load(R.drawable.img_prod1_1)
                .override(470, 470)
                .apply(RequestOptions.centerCropTransform())
                .into(binding.ivProdImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRvProductBaseBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(prodList[position])
    }

    override fun getItemCount(): Int {
        return prodList.size
    }
}