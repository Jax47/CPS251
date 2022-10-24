package com.ebookfrenzy.myapplication.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ebookfrenzy.myapplication.databinding.FragmentMainBinding

import androidx.databinding.DataBindingUtil
import com.ebookfrenzy.myapplication.R
import com.ebookfrenzy.myapplication.BR.viewModelB

//import androidx.lifecycle.Observer //Import for using LiveData

class MainFragment : Fragment() {


//    private var _binding: FragmentMainBinding? = null
//    private  val binding get() = _binding!!


    private val TAG = "FunctionCall"

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate was called")
        super.onViewCreated(view, savedInstanceState)

                                                    //Property assess complaint use setter instead
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.setVariable(viewModelB, viewModel)

//        if(viewModel.getList().isNotEmpty()){
//            binding.nameViewDisplay.text = viewModel.getList() //The line that redraw name when
//            // the device is rotated
//            Log.i(TAG, "onCreate-Past name enter was redrawn to display")
//        }

        /*val nameListObserver = Observer<String>{
            nameList -> binding.nameViewDisplay.text = nameList.toString()
        }

        viewModel.getList().observe(viewLifecycleOwner, nameListObserver)*/

        //Listener that call the triggerAction method when the button is click
        /*binding.addNameButton.setOnClickListener{
            triggerAction()
        }

        //Listener that call triggerAction when the enter key is pressed in the textEdit widget
        binding.nameView.setOnEditorActionListener { _, actionId, _ ->
            when(actionId){
                EditorInfo.IME_ACTION_DONE ->{
                    triggerAction() ; true
                }else -> false
            }
        }*/
    }

    /**
     * Contain the action to be performed when an button event
     * is fired or when the enter key is pressed in the text
     * edit widget
     */
    /*private fun triggerAction(){
        if(binding.nameView.text.isNotEmpty()){
            viewModel.setName(binding.nameView.text.toString())
            viewModel.addName()
            binding.nameViewDisplay.text = viewModel.getList().value
            Log.i(TAG, "onCreate-Name added to list")
        } else{
            binding.nameViewDisplay.text = "Invalid Name"
            Log.i(TAG, "onCreate-Invalid name enter")
        }
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        return inflater.inflate(R.layout.fragment_main, container, false)

//        _binding = FragmentMainBinding.inflate(inflater, container, false)
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )
        //The line below allow the instance to be destroy once the fragment goes away
        binding.lifecycleOwner = this //Complain about property assess so use setter instead

        return binding.root
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

}