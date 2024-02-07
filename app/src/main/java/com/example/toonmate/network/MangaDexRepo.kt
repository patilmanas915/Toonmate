package com.example.toonmate.network

import com.example.toonmate.screen.searchscreen.data.SearchData
import com.example.toonmate.screen.searchscreen.data.mangaData
import javax.inject.Inject

class MangaDexRepo@Inject constructor(private val mangaDexServices: MangaDexServices) {

    suspend fun getsearchData(name:String):SearchData{
        return mangaDexServices.getSearchData(name)
    }

    suspend fun getmanagadata(id:String):mangaData{
        return mangaDexServices.getMangaDetails(id)
    }
}