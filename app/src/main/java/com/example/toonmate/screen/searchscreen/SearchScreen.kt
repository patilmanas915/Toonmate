package com.example.toonmate.screen.searchscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.toonmate.ui.theme.ToonmateTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: SeacrchViewModel= hiltViewModel<SeacrchViewModel>()
) {
    var searchData by remember { mutableStateOf("") }
    val list by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary
            ),
                title = {

                    val focusRequester = remember { FocusRequester() }

                    LaunchedEffect(Unit) {
                        focusRequester.requestFocus()
                    }
                    TextField(
                        value = searchData,
                        onValueChange = { searchData = it },
                        modifier
                            .padding(6.dp)
                            .focusRequester(focusRequester),
                        placeholder = {

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Spacer(modifier = Modifier.padding(2.dp))
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = null
                                    )
                                    Text(
                                        text = "Manga title|Author name"
                                    )
                                }
                            }

                        }, colors = TextFieldDefaults.colors(
                            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            focusedIndicatorColor = Color.Gray.copy(alpha = 0.5f),
                            unfocusedIndicatorColor = Color.Gray.copy(alpha = 1f),
                            disabledIndicatorColor = Color.Gray.copy(alpha = 0.5f),
                            errorIndicatorColor = Color.Transparent

                        ),
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Search
                        ),
                        keyboardActions = KeyboardActions(
                            onSearch = {
//                                viewModel.SearchManga(searchData)

                            }
                        )
                    )

                },
                actions = {
                    IconButton(
                        onClick = { viewModel.SearchManga(searchData)}) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )

                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = null
                        )

                    }
                })


        },
    ) { it ->
        LazyColumn(contentPadding = it, content = {
            itemsIndexed(list){
            index, item->
                SearchCard(item.title,item.img)
            }
        })

    }
    if (viewModel.loading){
        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator()
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchCard(name:String,url:String,modifier: Modifier = Modifier) {
    Card(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {
        Row(
            modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = url,
                contentDescription = null,
                modifier
                    .weight(3f)
                    .size(60.dp)
            )
            Column(modifier.weight(6.5f)) {
                Text(text =name)
            }
        }
    }

}
