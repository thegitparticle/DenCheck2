package com.example.dencheck2.quote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dencheck2.network.ClansItem
import com.example.dencheck2.network.UserDetailsApi
import kotlinx.coroutines.launch

class QuoteFragmentViewModel: ViewModel() {
    private val _response = MutableLiveData<List<ClansItem>>()
    val response: LiveData<List<ClansItem>>
        get() = _response

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String>
        get() = _userName

    override fun onCleared() {
        super.onCleared()
        Log.i("QuoteFragmentViewModel", "QuoteFragmentViewModel destroyed")
    }

    init {
        getUserDetailsHere()
    }

    private fun getUserDetailsHere() {
        viewModelScope.launch {
            try {
                val userResult = UserDetailsApi.retrofitService.getUserDetails()
                _userName.value = userResult[2].club_name
            } catch (e: Exception) {
                _userName.value = "morning"
                Log.i("QuoteViewModel", "API call for user details, Failed! ${e.message}")
            }
        }
    }
}