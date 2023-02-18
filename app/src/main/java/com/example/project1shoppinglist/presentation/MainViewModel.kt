package com.example.project1shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.example.project1shoppinglist.data.ShopListRepositoryImpl
import com.example.project1shoppinglist.domain.DeleteItemUseCase
import com.example.project1shoppinglist.domain.EditShopItemUseCase
import com.example.project1shoppinglist.domain.GetShopListUseCase
import com.example.project1shoppinglist.domain.entity.ShopItem

class MainViewModel: ViewModel() {

    //Это неправильный способ передачи репозитория потому что вью модель стала зависеть от дата слоя.
    //Правильный инъекция зависимостей.
    private val repository = ShopListRepositoryImpl


    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteItemUseCase = DeleteItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    //Взаимодействие активити и вью модели должно происходить через лайв дату.
    // У нас должен быть объект объект лайв дата на который можно подписаться из активити или фрагмента.
    //Получаем список
    //val shopList = MutableLiveData<List<ShopItem>>()

    val shopList = getShopListUseCase.getShopList()

    /*fun getShopList(){
        //получаем список элементов из getShopListUseCase
        val list =  getShopListUseCase.getShopList()
        //устанавливаем в LiveData
        shopList.value = list
        //из активити мы сможем подписать ся на нашу LiveData - shopList
    }*/

    //Удаляем
    fun deleteShopItem(shopItem: ShopItem) {
        deleteItemUseCase.deleteShopItem(shopItem)
        //getShopList()
    }

    //Меняем состояние
    fun changEnableState(shopItem: ShopItem) {
        //создаем копию объекта
        //(enabled = shopItem.enabled) - именованные параметры
        //передаем противоположное значение !shopItem.enabled)
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
        //обновляем список элементов
        //getShopList()

    }



}