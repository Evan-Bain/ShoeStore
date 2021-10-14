package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import kotlinx.android.synthetic.main.shoe_list_item.view.*

class ShoeListFragment : Fragment() {

    //Create instance of viewmodel.
    private val sharedViewModel: ShoeViewModel by activityViewModels()

      override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        setHasOptionsMenu(true)

          binding.setLifecycleOwner(this)
        //Observe the list in the ViewModel and inflate/add a new shoe_list_item view whenever a new shoe is added.
        sharedViewModel.shoe.observe(viewLifecycleOwner,
            Observer {
                sharedViewModel.shoelist.forEach { shoe ->
                    val view: View = inflater.inflate(R.layout.shoe_list_item, null, false)
                    view.shoe_brand_text_view.text =
                        String.format(getString(R.string.brand_name), shoe.brand)
                    view.shoe_type_text_view.text =
                        String.format(getString(R.string.type_name), shoe.type)
                    view.size_group_text_view.text =
                        String.format(getString(R.string.size_grouping), shoe.sizeGroup)
                    view.shoe_size_text_view.text =
                        String.format(getString(R.string.shoe_size), shoe.size)
                    view.shoe_description_text_view.text =
                        String.format(getString(R.string.description), shoe.description)
                    view.line_divider
                    binding.shoeList.addView(view)
                }
            })

        //When the user clicks the fab, navigate to the detail fragment.
        binding.fab.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId != R.id.loginFragment){
            logout()
    }
        return super.onOptionsItemSelected(item)
    }
    private fun logout() {
        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
    }
}