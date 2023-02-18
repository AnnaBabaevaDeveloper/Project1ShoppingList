package com.example.project1shoppinglist.domain.repository

import androidx.lifecycle.LiveData
import com.example.project1shoppinglist.domain.entity.ShopItem

interface ShopListRepository {

    //Получаем весь список покупок.
    fun getShopList(): LiveData<List<ShopItem>>

    //Добавляет элемент в список
    fun  addShopItem(shopItem: ShopItem)

    //Ролучает элемент по Id
    fun getShopItem(shopItemId: Int): ShopItem

    fun editShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

}