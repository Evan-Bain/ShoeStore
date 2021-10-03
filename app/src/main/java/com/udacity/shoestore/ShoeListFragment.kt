package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import kotlinx.android.synthetic.main.fragment_shoe_list.view.*
import kotlinx.android.synthetic.main.fragment_shoe_list.view.shoe_brand_text_view
import kotlinx.android.synthetic.main.fragment_shoe_list.view.shoe_style_text_view
import kotlinx.android.synthetic.main.shoe_list_item.view.*

class ShoeListFragment : Fragment() {

    //Create instance of viewmodel
    private val sharedViewModel: ShoeViewModel by activityViewModels()

    //create binding object. (Why is this lateinit?)
    private lateinit var binding: FragmentShoeListBinding
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
        inflater,
        R.layout.fragment_shoe_list,
        container,
        false
        )

        binding.setLifecycleOwner(this)
        //Observe the list in the viewmodel and inflate/add a new shoe_list_item view whenever a new shoe is added.
            sharedViewModel.shoeList.observe(viewLifecycleOwner,
                Observer { sampleShoeList -> sampleShoeList.forEach {shoeNameT ->
                val view: View = inflater.inflate(R.layout.shoe_list_item, null, false)
                view.shoe_brand_text_view.text = shoeNameT.name
                    view.shoe_style_text_view.text = shoeNameT.style
                binding.shoeList.addView(view)
            }
                })

    //When the user clicks the fab, navigate to the detail fragment.
        binding.fab.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        return binding.root
    }
}