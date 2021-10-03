package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    //LiveData object for an individual shoe
    private val _shoeNameT = MutableLiveData<ShoeNameT>()
    val shoeNameT: LiveData<ShoeNameT>
        get() = _shoeNameT

    //MutableList of ShoeNameT LiveData objects.
    private var _shoeList = MutableLiveData<MutableList<ShoeNameT>>()
    val shoeList: MutableLiveData<MutableList<ShoeNameT>>
        get() = _shoeList


    init {
        //Sets the initial value of the shoeName
        _shoeNameT.value = ShoeNameT("", style = "")
                //Runs the shoeList function below.
        _shoeList.value = shoeList()

    }

    //This method executes when the user clicks on the AddANewShoe button in the detail fragment.
    //It sets the value of the shoe name that was entered and adds it to the MutableList.
    fun addShoe(shoeInfo: ShoeNameT) {
        _shoeNameT.value = shoeInfo
        _shoeList.value?.add(_shoeNameT.value!!)
    }

    //This function returns the list of shoes.
    private fun shoeList(): MutableList<ShoeNameT> {
     return mutableListOf(
     ShoeNameT("", style = ""))

    }

}