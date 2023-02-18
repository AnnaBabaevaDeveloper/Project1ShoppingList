package com.example.project1shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.project1shoppinglist.R

class MainActivity : AppCompatActivity() {

    //Когда мы знаем, что точно будем присваивать значение, то пишем lateinit var,
    // чтобы не делать постоянную проверку на null
    private lateinit var viewModel: MainViewModel

    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //подпишемся на шоп лист
        viewModel.shopList.observe(this){
            //Через лямбда выражение подпишемся на observe. Сюда будут прилетать вс новые элементы
            Log.d("MainActivityTest", it.toString())
            if (count == 0){
                count++
                val item = it[0]
                viewModel.changEnableState(item)
            }
        }
        //viewModel.getShopList()
    }
}