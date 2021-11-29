package com.fasterdes.recipecatalogue.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.fasterdes.recipecatalogue.R
import com.fasterdes.recipecatalogue.adapter.RecipesAdapter
import com.fasterdes.recipecatalogue.data.DataRecipes
import com.fasterdes.recipecatalogue.data.Recipes
import com.fasterdes.recipecatalogue.databinding.FragmentSeafoodBinding

class SeafoodFragment : Fragment() {

    private var binding : FragmentSeafoodBinding? = null // Keadaan binding msih kosong dari fragment akan disi di onCreateView
    private var listSeafood : ArrayList<Recipes> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentSeafoodBinding.inflate(inflater , container , false)

        initData()

        return binding!!.root // Binding yang kosong akan diisi
    }

    private fun initData() {

        with(resources) {
            val name = getStringArray(R.array.name_seafood)
            val category = getStringArray(R.array.category_seafood)
            val description = getStringArray(R.array.description_seafood)
            val ingredients = getStringArray(R.array.ingredients_seafood)
            val instruction = getStringArray(R.array.instructions_seafood)
            val photo = getStringArray(R.array.photo_seafood)
            val price = getStringArray(R.array.price_seafood)
            val calories = getStringArray(R.array.calories_seafood)
            val carbo = getStringArray(R.array.carbo_seafood)
            val protein = getStringArray(R.array.protein_seafood)


            for (data in name.indices) {
                val recipe = Recipes(
                    name[data],
                    category[data],
                    description[data] ,
                    ingredients[data] ,
                    instruction[data] ,
                    photo[data],
                    price[data] ,
                    calories[data] ,
                    carbo[data] ,
                    protein[data]
                )

                listSeafood.add(recipe)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.rvSeafood?.apply {
            layoutManager = GridLayoutManager(activity , 2 )
            adapter = RecipesAdapter(listSeafood)
        }
    }

    override fun onDestroy() { // Sudah menjadi bagian dalam fragment
        super.onDestroy()
        binding = null // binding dikosongkan lagi
    }
}


/*
*
*
*
* */