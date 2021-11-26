package com.example.coroutine_example_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test()

    }

     fun test(){
        vm.test()
    }
}