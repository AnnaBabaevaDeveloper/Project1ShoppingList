package com.example.project1shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.project1shoppinglist.domain.entity.ShopItem
import com.example.project1shoppinglist.domain.repository.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {

    //создаем переменную в которой будем хранить коллекцию элементов
    private val shopList = mutableListOf<ShopItem>()
    //Создали объект, который будем возвращать
    private val shopListLD = MutableLiveData<List<ShopItem>>()

    //При добавлении в коллекцию нам нужно установить правильный айди
    private var autoIncrementId = 0

    //добавим для теста элементы
    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        //вернем данную коллекцию
        //на самом деле возвращать саму коллецию не хорошо поскольку мы тогда сможем
        //из других мест программы добавлять новые элементы в данную коллекцию или удалять их
        //Лучше возвращать копию этой коллекции т.е такую же коллекцию с тем же набором элементов,
        // но сам оюъект будет другой.
        //В этом случае при добавлении или удалении новых элементов это никак не повлияет на
        // исходную коллекцию. чтобы создать копию листа необходимо ызвать метод .toList()
        //Если это ихменяемая коллекция, то .toMutableList()
        //return shopList.toList()

        return shopListLD
    }

    override fun addShopItem(shopItem: ShopItem) {
        //При добавлении элемента мы установим у нашего элемента autoIncrementId
        //shopItem.id = autoIncrementId
        //после этого увеличим его значение на единицу
        //autoIncrementId++

        //проверка есть ли такой айди
        if (shopItem.id == ShopItem.UNDEFINED_ID){
            //запись можно сократить
            shopItem.id = autoIncrementId++
        }else{
            //добавим новый элемент в коллекцию
            shopList.add(shopItem)
            updateList()
        }

    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        //Ищем элемент по айди и возарвщаем его
        //Возвращаем shopList Вызываем метод find он принимает в качестве параметра предикат
        // функцию, которая возвращает тру или фолсе
        //далее мы ищем элемент укоторого айди равен переданному айди.
        //Далее возникает ошибка потому что метод может вернуть ноль, если может,
        //то можно изменить возвращаемй тип у метода getShopItem на нулабельный, если нет, то бросаем исключение
        //?: throw RuntimeException("Element with id $shopItemId not found")

        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun editShopItem(shopItem: ShopItem) {
        //удаляем старый объект и кладем новый
        //Для этого сначал ищем старый элемент по айди и удаляем его, а потом доьавялем новый элемент.
        //ищем
        val oldElement = getShopItem(shopItem.id)
        //удаляем
        shopList.remove(oldElement)
        //вставляем
        addShopItem(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        //удалим элемент из коллекции
        shopList.remove(shopItem)
        updateList()
    }

    //метод, который будет обновлять объект лайв дата
    private fun updateList(){
        shopListLD.value = shopList.toList()
    }

}