package com.ebookfrenzy.lifecycledemo

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.ebookfrenzy.lifecycledemo.databinding.FragmentMainBinding
import com.ebookfrenzy.lifecycledemo.ui.main.MainViewModel
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class LifeCycleObserver: LifecycleEventObserver {

    private var observation = ""

    var mainView = MainViewModel

    fun getObservation(): String {
        return this.observation
    }

    fun addObservation(observationN: String) {
        this.observation + observationN
        mainView.updateObs(observationN)
    }

    private fun getString(event: Lifecycle.Event, time: LocalTime): String{
        return "$event was fired on ${time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))}"
    }

    private fun getTime(): LocalTime {
        return LocalTime.now()
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event){
            Lifecycle.Event.ON_CREATE -> {
//                this.observation = observation + getString(event, getTime()) + "\n"
                addObservation(getString(event, getTime()) + "\n")
            }
            Lifecycle.Event.ON_START -> {
//                this.observation = observation + getString(event, getTime()) + "\n"
            }
            Lifecycle.Event.ON_RESUME -> {
//                this.observation = observation + getString(event, getTime()) + "\n"
                addObservation(getString(event, getTime()) + "\n")
            }
            Lifecycle.Event.ON_PAUSE -> {
//                this.observation = observation + getString(event, getTime()) + "\n"
                addObservation(getString(event, getTime()) + "\n")
            }
            Lifecycle.Event.ON_STOP -> {
//                this.observation = observation + getString(event, getTime()) + "\n"
                addObservation(getString(event, getTime()) + "\n")
            }
            Lifecycle.Event.ON_DESTROY -> {
//                this.observation = observation + getString(event, getTime()) + "\n"
                addObservation(getString(event, getTime()) + "\n")
            }
            Lifecycle.Event.ON_ANY -> {
                //For now do nothing
            }
        }
    }
}