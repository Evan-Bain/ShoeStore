package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : androidx.fragment.app.Fragment() {

    //create instance of the viewmodel
    private val sharedViewModel: ShoeViewModel by activityViewModels()

    //create instance of the ShoeName class
    private val shoeEntry = ShoeNameT("", style = "")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class.
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

//.shoeDetail is the variable in the xml file for the detail layout.
        binding.shoeDetail = shoeEntry
        //runs the addShoe method below when button is clicked. shoeName.name is the value in the EditText of the shoe_detail layout
        binding.addShoeButton.setOnClickListener{view: View -> addShoe(shoeEntry.name, shoeEntry.style)}

        return binding.root

    }

    //Runs the addShoe method (defined in the ViewModel) and navigates to the list screen.

    fun addShoe(name: String, style: String){
        sharedViewModel.addShoe(shoeEntry)
      view?.findNavController()?.navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
    }

}