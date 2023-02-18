package com.example.project1shoppinglist.domain

import com.example.project1shoppinglist.domain.entity.ShopItem
import com.example.project1shoppinglist.domain.repository.ShopListRepository


//Добавляет элемент в список
class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    //принимает ShopItem и ничего не возвращает
    fun  addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }

}