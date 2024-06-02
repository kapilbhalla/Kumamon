package com.example.kumamon.android

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kumamon.data.OaiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(model: OaiModel, dispatcher: CoroutineDispatcher = Dispatchers.IO):
    ViewModel() {

    private val _latestMessage = MutableLiveData<String>()
    val latestMessage: LiveData<String> = _latestMessage

    init {
        viewModelScope.launch(dispatcher) {
            try {
                var response = model.converse("What is your favorite sport?")
                _latestMessage.postValue(response)
                response = model.converse("Please recommend an inexpensive food to eat")
                _latestMessage.postValue(response)
            } catch (ex: Exception) {
                Log.d("TRACE", "error conversing in viewmodel ${ex.message}")
            }
        }
    }
}