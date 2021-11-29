package com.fasterdes.recipecatalogue.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.fasterdes.recipecatalogue.adapter.RecipesAdapter
import com.fasterdes.recipecatalogue.data.DataRecipes
import com.fasterdes.recipecatalogue.databinding.FragmentDessertBinding

class DessertFragment : Fragment() {

    private var binding : FragmentDessertBinding? = null // Keadaan binding msih kosong dari fragment akan disi di onCreateView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentDessertBinding.inflate(inflater , container , false)
        return binding!!.root // Binding yang kosong akan diisi
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.rvDessert?.apply {
            layoutManager = GridLayoutManager(activity , 2 )
            adapter = RecipesAdapter(DataRecipes.listDessert)
        }
    }

    override fun onDestroy() { // Sudah menjadi bagian dalam fragment
        super.onDestroy()
        binding = null // binding dikosongkan lagi
    }
}