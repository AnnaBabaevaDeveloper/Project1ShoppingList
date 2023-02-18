package com.example.project1shoppinglist.domain

import com.example.project1shoppinglist.domain.entity.ShopItem
import com.example.project1shoppinglist.domain.repository.ShopListRepository

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)

    }
}