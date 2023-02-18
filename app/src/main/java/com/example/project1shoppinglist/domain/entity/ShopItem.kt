package com.example.project1shoppinglist.domain.entity

data class ShopItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,

    //реализация id без базы данных
    //она в конце потому что принято, что обязательные поля указываются первыми
    //но так писать нельзя - это жесткое кодирование, такие числа называются
    // магическими числами из использование это плохая практика
    var id: Int = UNDEFINED_ID,

    ) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}


