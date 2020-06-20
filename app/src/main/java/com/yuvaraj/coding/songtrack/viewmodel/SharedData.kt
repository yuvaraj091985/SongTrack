package com.yuvaraj.coding.songtrack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedData : ViewModel() {

    val data = MutableLiveData<String>()

    fun data(value :String) {
        data.value = value
    }
}