package com.ebookfrenzy.navproject

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.navproject.ui.main.MainFragment

class MainActivity : AppCompatActivity(),
    SecondFrag.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment.newInstance())
//                .commitNow()
//        }
    }

    override fun onFragmentInteraction(uri: Uri) {

    }


}