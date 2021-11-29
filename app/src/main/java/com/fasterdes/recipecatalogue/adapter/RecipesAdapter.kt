package com.fasterdes.recipecatalogue.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fasterdes.recipecatalogue.DetailActivity
import com.fasterdes.recipecatalogue.data.Recipes
import com.fasterdes.recipecatalogue.databinding.RowItemFoodBinding

class  RecipesAdapter(private val listRecipes: ArrayList<Recipes>) :
    RecyclerView.Adapter<RecipesAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RowItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemFoodBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            with(listRecipes[position]) /* object listRecipes */{
                tvFood.text = name
                tvFoodCategory.text = category
                tvPriceFood.text = price

                // Load image from url
                Glide.with(imgFood.context).load(photo).into(imgFood)
            }
        } // Holder akan ngebinding sekalian index number listrecipes


        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DATA_RECIPES, listRecipes[position])
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listRecipes.size
}