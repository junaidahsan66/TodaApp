package com.aexample.todoapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aexample.todoapp.models.ResponseModel
import com.aexample.todoapp.network.ApiClient
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    private val _todoList:MutableLiveData<ArrayList<ResponseModel>> = MutableLiveData()
            val todoList : LiveData<ArrayList<ResponseModel>>
            get() = _todoList


    fun getTodoList(){
        viewModelScope.launch {
            val result = ApiClient.apiInterface?.getDataList()
            result?.let {
                _todoList.postValue(it)
            }
        }
    }
}