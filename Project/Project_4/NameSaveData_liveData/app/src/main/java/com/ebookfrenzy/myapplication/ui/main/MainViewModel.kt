package com.ebookfrenzy.myapplication.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {

     var name: MutableLiveData<String> = MutableLiveData("")
     var nameList: MutableLiveData<String> = MutableLiveData("")

    private val TAG = "FunctionCall"


    fun addNameToList(){
        name.let {
            if (!it.value.equals("")){
                nameList.value = nameList.value + it.value + "\n"
            }else{
//                nameList.value = ""
                name.value = "Invalid name try again"
            }
        }
    }

//    fun setName(name: String){
//        this.name = name
//        Log.i(TAG, "setName: $name")
//    }

//    fun addName(){
////        this.nameList = nameList + name + "\n"
//        nameList.value = nameList.value + name + "\n"
//        Log.i(TAG, "addName: ${nameList.value}, $name")
//    }

//    fun getList(): MutableLiveData<String> {
//        Log.i(TAG, "nameList: ${nameList.value}")
//        return this.nameList
//    }

//    fun getName(): String{
//        Log.i(TAG, "getName: $name")
//        return name
//    }
}