package com.example.myjetpacgassnmntapplication.viewmodel

import androidx.lifecycle.*
import com.example.myjetpacgassnmntapplication.data.model.ItemData
import com.example.myjetpacgassnmntapplication.data.repos.ItemRepository
import com.example.myjetpacgassnmntapplication.data.repos.ItemRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemListViewmodel constructor(val itemRepository: ItemRepository):ViewModel() {


    val itemDatas : MutableLiveData<List<ItemData>> by lazy { MutableLiveData<List<ItemData>>() }

    fun addItems(data: ItemData?){
        viewModelScope.launch(context = Dispatchers.Main){
            itemRepository.insertItem(data!!) }
    }

    fun getItem() {
        viewModelScope.launch(context = Dispatchers.Main) {
            itemDatas.value=itemRepository.getItemData()
        }
        /*liveData<List<ItemData>> {
            itemRepository.getItemData().asLiveData(context = Dispatchers.Main)
        }*/
    }

    fun deleteItem(data: ItemData){
        itemRepository.deleteItem(data)
        getItem()
    }

}