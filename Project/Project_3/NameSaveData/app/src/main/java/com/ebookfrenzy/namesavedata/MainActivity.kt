package com.ebookfrenzy.namesavedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.namesavedata.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private val TAG = "FunctionCall"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
//            Log.i(TAG,"onCreate-MainActivity")
        }
    }
}