package com.example.singlelivedatatest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.singlelivedatatest.event.MutableSingleLiveData
import com.example.singlelivedatatest.event.SingleLiveData

class MainViewModel : ViewModel() {
    private val _liveDataEvent = MutableLiveData<Unit>()
    val liveDataEvent: LiveData<Unit> get() = _liveDataEvent

    private val _singleLiveDataEvent = MutableSingleLiveData<Unit>()
    val singleLiveDataEvent: SingleLiveData<Unit> get() = _singleLiveDataEvent

    fun triggerLiveDataEvent() {
        _liveDataEvent.value = Unit
    }

    fun triggerSingleLiveDataEvent() {
        _singleLiveDataEvent.setValue(Unit)
    }
}

