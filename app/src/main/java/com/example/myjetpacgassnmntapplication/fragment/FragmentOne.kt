package com.example.myjetpacgassnmntapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myjetpacgassnmntapplication.R
import com.example.myjetpacgassnmntapplication.databinding.FragmentOneBinding
import com.example.myjetpacgassnmntapplication.ui.ItemDataAdapter
import com.example.myjetpacgassnmntapplication.viewmodel.ItemListViewmodel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentOne : Fragment(),View.OnClickListener {
    // TODO: Rename and change types of parameters
    lateinit var navController: NavController
    lateinit var binding: FragmentOneBinding
   private val itemListViewmodel: ItemListViewmodel by viewModel()
//   private val itemDataAdapter: ItemDataAdapter =ItemDataAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_one, container, false)

        inits()
        return binding.root
    }

    private fun inits() {
//        itemListViewmodel = ViewModelProvider(this)[ItemListViewmodel::class.java]
itemListViewmodel.getItem()
itemListViewmodel.itemDatas.observe(viewLifecycleOwner, Observer {
    binding.rvItemList.apply {
        adapter=ItemDataAdapter(it,{
            itemListViewmodel.deleteItem(this)
        })
        layoutManager=LinearLayoutManager(activity)
        setHasFixedSize(true)
    }
})

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.floatingActionButton->navController.navigate(R.id.action_mainFragment_to_AddItemFragment)
        }
    }

}