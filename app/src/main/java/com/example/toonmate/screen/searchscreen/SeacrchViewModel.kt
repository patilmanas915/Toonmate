package com.example.toonmate.screen.searchscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toonmate.network.MangaDexRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class SeacrchViewModel @Inject constructor(private val mangaDexRepo: MangaDexRepo) : ViewModel() {
    private val _uiState = MutableStateFlow<List<ListData>>(emptyList())
    val uiState: StateFlow<List<ListData>> = _uiState.asStateFlow()
    val loading =MutableStateFlow<Boolean>( false)
    val _loading=loading.asStateFlow()
    fun SearchManga(name: String) {
        viewModelScope.launch {
            loading.value = true
            val templist = mutableListOf<ListData>()
            println(name)
            val result = mangaDexRepo.getsearchData(name).data
            //val result2= callApi(name)
            for (i in result) {
                val id = i.id
                println(id)
                val name = i.attributes.title.en
                println(name)
                val description = i.attributes.description.en
                val mangadata = mangaDexRepo.getmanagadata(id)
                var coverimgid:String=""
                var coverurl:String
                try {
                    coverimgid = mangadata.data.relationships[2].attributes.fileName
                    coverurl= "https://uploads.mangadex.org/covers/$id/$coverimgid"
                }
                catch (e:Exception){
                    coverimgid="https://mangadex.org/covers/b4d3b49b-142f-4283-9401-37b6565caea6/9a8c1099-fdb7-4c54-b8c3-e72e60b1dd7d.jpg"
                    coverurl= coverimgid
                }
                println(coverurl)

                val newdata = ListData(
                    id,
                    coverurl,
                    name,
                    mangadata.data.attributes.tags[0].attributes.name.en,
                    description
                )
                templist.add(newdata)
            }
            _uiState.value = templist
            loading.value = false

        }


    }

}

