package com.example.toonmate.network

import com.example.toonmate.screen.readerscreen.data.chapterldata
import com.example.toonmate.screen.readerscreen.newdata.chapter
import com.example.toonmate.screen.searchscreen.data.SearchData
import com.example.toonmate.screen.searchscreen.data.mangaData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject

class MangaDexRepo@Inject constructor(private val mangaDexServices: MangaDexServices) {

    suspend fun getsearchData(name:String):SearchData{
        return mangaDexServices.getSearchData(name)
    }

    suspend fun getmanagadata(id:String):mangaData{
        return mangaDexServices.getMangaDetails(id)
    }
    suspend fun getmanagachapter(id:String): chapterldata {
        return mangaDexServices.getchapters(id)
    }
    suspend fun getchapterpages(id:String): chapter {
        return mangaDexServices.getpages(id)
    }
}

suspend fun callApi(link: String, product: String = "/manga?title="): String? {
    return withContext(Dispatchers.IO) {
        val client = OkHttpClient()
        val url = "https://api.mangadex.org/$product$link"
        val request = Request.Builder().url(url).build()

        try {
            // Make the API request using OkHttp
            val response = client.newCall(request).execute()

            if (response.isSuccessful) {
                print("success")
                response.body?.string()
            } else {
                print("fail")
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        } finally {
            client.connectionPool.evictAll()
        }
    }
}