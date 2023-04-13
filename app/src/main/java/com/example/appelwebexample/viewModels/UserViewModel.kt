package com.example.appelwebexample.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appelwebexample.`class`.User
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    val users = MutableLiveData<List<User>>()

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    fun getUsers() {
        viewModelScope.launch {
            try {
                users.value = UserApi.retrofitService.getUsers()
                _status.value = "Success:  Users retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}
