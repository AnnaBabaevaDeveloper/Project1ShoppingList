package com.example.project1shoppinglist.domain

import androidx.lifecycle.LiveData
import com.example.project1shoppinglist.domain.entity.ShopItem
import com.example.project1shoppinglist.domain.repository.ShopListRepository

//UseCase GetShopListUseCase
class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    //Метод, который получает весь список покупок.
    //Не принимает параметров и возвращает лист наших элементов.
    fun getShopList(): LiveData<List<ShopItem>> {

        //Здесь return потому что метод возвращает : ShopItem
        //Если ничего не возвращает, то без return

        return shopListRepository.getShopList()
    }


}