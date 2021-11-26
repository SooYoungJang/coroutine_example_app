package com.example.coroutine_example_app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {


    fun test() {
        val startTime = System.currentTimeMillis()
        val job = viewModelScope.launch(Dispatchers.Main) {
            var nextPrintTime = startTime
            var i = 0
            println("job:I'm Isssss ${Thread.currentThread().name}")
            withContext(Dispatchers.IO) {
                while (i < 5) { // computation loop, just wastes CPU
                    // print a message twice a second
                    if (System.currentTimeMillis() >= nextPrintTime) {
                        println("job: I'm sleeping ${i++} ... ${Thread.currentThread().name}")
                        nextPrintTime += 500L
                    }
                }
            }


            withContext(Dispatchers.Default) {
                delay(1300L) // delay a bit
                println("main: I'm tired  waiting! ${Thread.currentThread().name}")
            }
        }
    }
}