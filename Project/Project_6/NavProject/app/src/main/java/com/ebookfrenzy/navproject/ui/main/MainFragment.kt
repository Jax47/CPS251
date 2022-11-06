package com.ebookfrenzy.navproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ebookfrenzy.navproject.R

import com.ebookfrenzy.navproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val TAG = "NAV"

    companion object {
        fun newInstance() = MainFragment()
    }


    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // TODO: Use the ViewModel

        binding.firstBtn.setOnClickListener{
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.setArgTitle("Image 1")

            Log.i(TAG, "Args: ${action.argTitle}")

            action.mainImage = R.drawable.android_image_1

            Navigation.findNavController(it).navigate(
                action
//                R.id.mainToSecond
            )
        }

        binding.ssecondBtn.setOnClickListener{
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()


            action.mainImage = R.drawable.android_image_2
            action.argTitle = "Image 2"
            Log.i(TAG, "Args: ${action.argTitle}, ${action.mainImage}")

            Navigation.findNavController(it).navigate(
                action
//                R.id.mainToSecond

            )
        }

        binding.thirdBtn.setOnClickListener{
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.mainImage = R.drawable.android_image_3
            action.argTitle = "Image 3"

            Log.i(TAG, "Args: ${action.argTitle}, ${action.mainImage}")

            Navigation.findNavController(it).navigate(
                action
//                R.id.mainToSecond
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}