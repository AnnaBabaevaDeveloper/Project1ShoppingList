package com.example.project1shoppinglist.domain

import com.example.project1shoppinglist.domain.entity.ShopItem
import com.example.project1shoppinglist.domain.repository.ShopListRepository

//Ролучает элемент по Id
class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    //Принимает ShopItemId типа Int  и возвращает ShopItem
    fun getShopItem(shopItemId: Int): ShopItem {

        //Здесь return потому что метод возвращает : ShopItem
        //Если ничего не возвращает, то без return
        return shopListRepository.getShopItem(shopItemId)
    }
}