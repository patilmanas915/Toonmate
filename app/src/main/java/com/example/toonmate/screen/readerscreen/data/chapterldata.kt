package com.example.toonmate.screen.readerscreen.data

data class chapterldata(
    val `data`: List<Data>,
    val limit: Int,
    val offset: Int,
    val response: String,
    val result: String,
    val total: Int
)