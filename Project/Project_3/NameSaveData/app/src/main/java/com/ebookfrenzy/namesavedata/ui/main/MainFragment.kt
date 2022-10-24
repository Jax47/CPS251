package com.ebookfrenzy.namesavedata.ui.main

//Import in order to use view binding
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import android.util.Log
import com.ebookfrenzy.namesavedata.databinding.FragmentMainBinding

class MainFragment : Fragment() {



    private lateinit var viewModel: MainViewModel

    private val TAG = "FunctionCall"

    private var _binding: FragmentMainBinding? = null
    private  val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        return inflater.inflate(R.layout.fragment_main, container, false)
        _binding = FragmentMainBinding.inflate(inflater, container, false)
//        Log.i(TAG, "onCreateView-MainFragment")
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
//        Log.i(TAG, "onDestroyView-MainFragment")
    }

    @SuppressLint("SetTextI18n")
    /*
    Replaced the onCreate the program added with onActivityCreated due to error
    where the binding var is null resulting in null pointer exception at runtime
    on line 25.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "Called onCreate")
//        super.onActivityCreated(savedInstanceState)
        super.onCreate(savedInstanceState)
        Log.i(TAG, "Setting up viewModel")
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

//        Log.i(TAG, "The value in the getList method is: " + viewModel.getList())
//        Log.i(TAG, "nameField value is: " + binding.nameField.text)
//        Log.i(TAG, "onCreate called accessing displayNameField through binding")

        Log.i(TAG, "Checking if viewModel list is empty")
        if(viewModel.getList().isNotEmpty()) {
            binding.displayNameField.text = viewModel.getList() //This Line is needed to redraw
            // the name if device is rotated
        }

//        Log.i(TAG, "Binding is not null: " + binding.equals(null))

        Log.i(TAG, "onCreate called finished accessing displayNameField through binding")

        Log.i(TAG, "Binding is not null: $binding")



        binding.addNameButton.setOnClickListener{
            if (binding.nameField.text.isNotEmpty()){
                viewModel.setName(binding.nameField.text.toString())
                viewModel.addName()
                binding.displayNameField.text = viewModel.getList()
//                Log.i(TAG, "onCreate-MainFragment")
            }else{
                binding.displayNameField.text = "Invalid Name"
//                Log.i(TAG, "onCreate-MainFragment")
            }
        }
    }


}