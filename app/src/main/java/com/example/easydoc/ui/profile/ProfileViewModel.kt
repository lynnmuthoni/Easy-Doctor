package com.example.easydoc.ui.emergency

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Any Emergencies to attend to"
    }
    val text: LiveData<String> = _text
}