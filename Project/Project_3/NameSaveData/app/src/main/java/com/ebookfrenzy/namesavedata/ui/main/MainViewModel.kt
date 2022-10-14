package com.ebookfrenzy.namesavedata.ui.main

import androidx.lifecycle.ViewModel
import android.util.Log
class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private var name = ""
    private var nameList = ""

    private val TAG = "FunctionCall"

    fun setName(name: String){
        this.name = name
        Log.i(TAG, "setName: $name")
    }

    fun addName(){
//        Log.i(TAG, "addName: $nameList, $name")
        this.nameList = nameList + name + "\n"
//        Log.i(TAG, "addName-MainViewModel")
    }

    fun getList(): String {
        Log.i(TAG, "getList-MainViewModel:" + this.nameList + ":")
        return this.nameList
    }
}