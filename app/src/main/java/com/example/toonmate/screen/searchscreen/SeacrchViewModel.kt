package com.example.toonmate.screen.searchscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toonmate.di.module.NetworkingModule
import com.example.toonmate.network.MangaDexRepo
import com.example.toonmate.screen.searchscreen.data.SearchData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject



@HiltViewModel
class SeacrchViewModel @Inject constructor(private val mangaDexRepo: MangaDexRepo): ViewModel() {
    private val _uiState = MutableStateFlow<List<ListData>>(emptyList())
    val uiState: StateFlow<List<ListData>> = _uiState.asStateFlow()
    var loading=false
    fun SearchManga(name:String) {
        viewModelScope.launch {
            loading=true
            val templist= mutableListOf<ListData>()
            println(name)
            val result=mangaDexRepo.getsearchData(name).searchData[0].id
            println(mangaDexRepo.getsearchData(name).result)
            println(result)
//            for(i in result){
//                println("1")
//                val id=i.id
//                println(id)
//                val name=i.attributes.title.en
//                println(name)
//                val description=i.attributes.description.en
//                println(description)
//                val mangadata=mangaDexRepo.getmanagadata(id)
//                println("suxx")
//                val coverimgid=mangadata.data.relationships[2].attributes.fileName
//                val coverurl="https://uploads.mangadex.org/covers/{$id}/{$coverimgid}"
//                val newdata=ListData(id,coverurl,name,mangadata.data.attributes.tags[0].attributes.name.en,description)
//                templist.add(newdata)
//                println("3")
//            }
//            _uiState.value=templist
            loading=false

        }


    }

}

