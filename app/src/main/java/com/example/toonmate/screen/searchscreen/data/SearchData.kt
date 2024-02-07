package com.example.toonmate.screen.searchscreen.data

data class SearchData(
    val searchData: List<Data> = emptyList(),
    val limit: Int = 0,
    val offset: Int = 0,
    val response: String = "",
    val result: String = "",
    val total: Int = 0
)
