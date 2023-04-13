package com.example.appelwebexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.appelwebexample.`class`.User
import com.example.appelwebexample.viewModels.UserViewModel
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        userViewModel.getUsers()

        // RAJOUTER <uses-permission android:name="android.permission.INTERNET" /> dans le manifest

        // Remplacer this par viewLifecycleOwner dans un viewModel
        userViewModel.users.observe(this) {
            Log.d("USERS: ", it.toString())
        }
    }
}