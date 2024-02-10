package com.example.toonmate.screen.readerscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toonmate.network.MangaDexRepo
import com.example.toonmate.screen.readerscreen.data.Data
import com.example.toonmate.screen.readerscreen.newdata.ChapterX
import com.example.toonmate.screen.readerscreen.newdata.chapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ComicScreenViewModel @Inject constructor(private val mangaDexRepo: MangaDexRepo) :ViewModel() {


    private val _chapter=MutableStateFlow<List<Data>>(emptyList())
    val chapter:StateFlow<List<Data>> = _chapter.asStateFlow()
    private val _pages=MutableStateFlow<chapter>(chapter("", ChapterX(emptyList(), emptyList(),""),""))
    val pages=_pages.asStateFlow()
     fun getchapters(id:String){
         viewModelScope.launch{
             _chapter.value =mangaDexRepo.getmanagachapter(id).data

         }

    }

    fun getpages(id:String){
        viewModelScope.launch{
            println("called")
            _pages.value=mangaDexRepo.getchapterpages(id)
            println("end")
        }

    }
}