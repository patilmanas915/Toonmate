package com.example.toonmate.network

import com.example.toonmate.screen.readerscreen.data.chapterldata
import com.example.toonmate.screen.readerscreen.newdata.chapter
import com.example.toonmate.screen.searchscreen.data.SearchData
import com.example.toonmate.screen.searchscreen.data.mangaData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaDexServices {

    @GET("/manga")
    suspend fun getSearchData(
        @Query("title") title: String
    ): SearchData

    @GET("/manga/{mangaId}")
    suspend fun getMangaDetails(
        @Path("mangaId") mangaId: String,
        @Query("includes[]") includes: List<String> = listOf("cover_art")
    ): mangaData

    @GET("/manga/{mangaId}/feed")
    suspend fun getchapters(@Path("mangaId") mangaId: String): chapterldata

    @GET("/at-home/server/{chapterId}")
    suspend fun getpages(@Path("chapterId") chapterId: String): chapter

}
