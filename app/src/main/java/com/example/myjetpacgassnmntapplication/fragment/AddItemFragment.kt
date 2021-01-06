package com.example.myjetpacgassnmntapplication.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.myjetpacgassnmntapplication.R
import com.example.myjetpacgassnmntapplication.data.model.ItemData
import com.example.myjetpacgassnmntapplication.databinding.FragmentAddItemBinding
import com.example.myjetpacgassnmntapplication.viewmodel.ItemListViewmodel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [AddItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddItemFragment : Fragment(),View.OnClickListener {
    // TODO: Rename and change types of parameters
lateinit var binding: FragmentAddItemBinding
private val addItemViewmodel: ItemListViewmodel by viewModel()
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_add_item, container, false)
        binding.item= ItemData()
        inits()
        return binding.root
    }

    private fun inits() {
//        addItemViewmodel = ViewModelProvider(this)[AddItemViewmodel::class.java]

    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun showToast() {
        Toast.makeText(activity!!.applicationContext,"Empty",Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button -> {
                if (binding.editTextNumber.text.isNullOrEmpty()){
                    binding.editTextNumber.error="Empty"
                }else if (binding.editTextNumberDecimal.text.isNullOrEmpty()){
                    binding.editTextNumberDecimal.error="Empty"
                }else if (binding.editTextNumberDecimal2.text.isNullOrEmpty()){
                    binding.editTextNumberDecimal2.error="Empty"
                }else if (binding.editTextTextPersonName.text.isNullOrEmpty()){
                    binding.editTextTextPersonName.error="Empty"
                }else{
                    addItemViewmodel.addItems(binding.item)
                    navController.navigate(R.id.fragmentOne)
                }
            }

        }
    }


}