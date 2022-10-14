package com.ebookfrenzy.namesavedata.ui.main

//Import in order to use view binding
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ebookfrenzy.namesavedata.databinding.FragmentMainBinding
import android.util.Log

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private val TAG = "FunctionCall"

    private var _binding: FragmentMainBinding? = null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        return inflater.inflate(R.layout.fragment_main, container, false)
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        Log.i(TAG, "onCreateView-MainFragment")
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.i(TAG, "onDestroyView-MainFragment")
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // TODO: Use the ViewModel
//        Log.i(TAG, "The value in the getList method is: " + viewModel.getList())
//        Log.i(TAG, "nameField value is: " + binding.nameField.text)
//        Log.i(TAG, "onCreate called accessing displayNameField through binding")

        binding.displayNameField.text = viewModel.getList() //This Line is needed to redraw
        // the name if device is rotated

//        Log.i(TAG, "onCreate called finished accessing displayNameField through binding")

        binding.addNameButton.setOnClickListener{
            if (binding.nameField.text.isNotEmpty()){
                viewModel.setName(binding.nameField.text.toString())
                viewModel.addName()
                binding.displayNameField.text = viewModel.getList()
                Log.i(TAG, "onCreate-MainFragment")
            }else{
                binding.displayNameField.text = "Invalid Name"
                Log.i(TAG, "onCreate-MainFragment")
            }
        }
    }


}