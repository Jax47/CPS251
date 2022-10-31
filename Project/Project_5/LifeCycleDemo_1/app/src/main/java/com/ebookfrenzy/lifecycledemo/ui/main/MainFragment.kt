package com.ebookfrenzy.lifecycledemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.ebookfrenzy.lifecycledemo.databinding.FragmentMainBinding

import com.ebookfrenzy.lifecycledemo.DemoObserver
import com.ebookfrenzy.lifecycledemo.DemoOwner
import com.ebookfrenzy.lifecycledemo.LifeCycleObserver

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel
    private lateinit var observer: LifeCycleObserver

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // TODO: Use the ViewModel

//        demoOwner = DemoOwner()
//        demoOwner.startOwner()
//        demoOwner.stopOwner()

        observer = LifeCycleObserver()
        lifecycle.addObserver(observer)

        //Connect the output view with the info from the observer
        if(viewModel.getObservation().value?.isNotEmpty() == true){
            binding.output.text =  viewModel.getObservation().value
        }

        val overSeer = Observer<String>{
            seer -> binding.output.text = seer.toString()
        }

        viewModel.getObservation().observe(viewLifecycleOwner, overSeer)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        return inflater.inflate(R.layout.fragment_main, container, false)

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}