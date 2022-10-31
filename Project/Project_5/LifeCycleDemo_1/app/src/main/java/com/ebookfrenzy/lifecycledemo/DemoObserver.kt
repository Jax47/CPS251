@file:Suppress("DEPRECATION")

package com.ebookfrenzy.lifecycledemo

import android.util.Log
import androidx.lifecycle.*
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle



class DemoObserver : DefaultLifecycleObserver {

//    private lateinit var time: String

    private val LOG_TAG = "DemoObserver"

    var observation: String = ""

    fun getTime(): String{
        return LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(LOG_TAG, "onResume, ${getTime()}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(LOG_TAG, "onPause, ${getTime()}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {

        Log.i(LOG_TAG, "onCreate, ${getTime()}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {

        Log.i(LOG_TAG, "onStart,  ${getTime()}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {

        Log.i(LOG_TAG, "onStop, ${getTime()}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {

        Log.i(LOG_TAG, "onDestroy, ${getTime()}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
        Log.i(LOG_TAG, owner.lifecycle.currentState.name + " " + event)


    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner) :String {
        return "${owner.lifecycle.currentState} was fired on ${getTime()}"
    }

}