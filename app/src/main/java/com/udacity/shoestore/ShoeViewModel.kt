package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    //LiveData object for an individual shoe
    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
        get() = _shoe

    //MutableList of LiveData Shoe objects.
    /*private var _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList*/

    val shoelist = ArrayList<Shoe>()

    init {
        //Sets the initial value of the shoeList
        _shoe.value = Shoe("", type = "", sizeGroup = "", size = "", description = "")
        //_shoeList.value = shoeList()

    }

    //This method executes when the user clicks on the AddANewShoe button in the detail fragment.
    //It sets the values in the shoe that was entered and adds it to the MutableList.
    fun addShoe(shoeInfo: Shoe) {
        _shoe.value = shoeInfo
        shoelist.add(shoe.value!!)
    }

    //This function returns the list of shoes with initial sample values.
    /*private fun shoeList(): MutableList<Shoe> {
        return mutableListOf(
            Shoe(
                "Nike",
                type = "Basketball",
                sizeGroup = "Women's",
                size = "8.5",
                description = "Black Kyrie 5"
            )
        )

    }*/

}