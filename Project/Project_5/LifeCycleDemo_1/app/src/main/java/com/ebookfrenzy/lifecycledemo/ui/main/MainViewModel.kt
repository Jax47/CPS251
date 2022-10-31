package com.ebookfrenzy.lifecycledemo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ebookfrenzy.lifecycledemo.LifeCycleObserver

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    companion object{
        private var observation: MutableLiveData<String> = MutableLiveData()

        fun updateObs(observationN: String){
            observation.value = observationN
        }

    }


    fun getObservation(): MutableLiveData<String>{
        return observation


    }
}