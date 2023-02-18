package com.example.project1shoppinglist.domain

import com.example.project1shoppinglist.domain.entity.ShopItem
import com.example.project1shoppinglist.domain.repository.ShopListRepository

//Удаляет элемент из списка
class DeleteItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}