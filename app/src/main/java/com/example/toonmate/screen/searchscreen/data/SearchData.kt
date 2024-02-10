package com.example.toonmate.screen.searchscreen.data

data class SearchData(
    val `data`:List<Data>,
    val limit: Int = 0,
    val offset: Int = 0,
    val response: String = "",
    val result: String = "",
    val total: Int = 0
)
