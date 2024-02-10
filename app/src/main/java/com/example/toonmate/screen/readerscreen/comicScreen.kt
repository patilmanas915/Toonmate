package com.example.toonmate.screen.readerscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.toonmate.navigation.AppScreen


@SuppressLint("StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComicScreen(
    navController: NavController,
    id: String,
    name: String,
    url: String,
    viewModel: ComicScreenViewModel =hiltViewModel<ComicScreenViewModel>(),
    modifier: Modifier = Modifier
) {

    val scope= rememberCoroutineScope()
    viewModel.getchapters(id)
    val chapterlist by viewModel.chapter.collectAsState()
    Scaffold(topBar = {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ), title = {
            Text(text = "Comic Detail")
        }, navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)

            }
        }, actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Share, contentDescription = null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
            }


        })
    }
    ) {
        Box {

            LazyVerticalGrid(
                columns = GridCells.Fixed(5),
                content = {
                    item(span = {
                        GridItemSpan(maxLineSpan)
                    }) {
                        Row(
                            modifier = Modifier
                                .padding(12.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            AsyncImage(
                                model = url,
                                contentDescription = null,
                                modifier = Modifier.size(120.dp, 180.dp)
                            )
                            Spacer(modifier = Modifier.padding(12.dp))
                            Column(
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = name,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 30.sp
                                )
                                Spacer(modifier = Modifier.padding(12.dp))
                                Button(
                                    onClick = { /*TODO*/ },
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSecondaryContainer)
                                ) {
                                    Text(text = "Download")
                                }
                            }
                        }
                    }
                    println(chapterlist.size)
                    itemsIndexed(chapterlist){index,item->
                        Button(
                            shape = RoundedCornerShape(8.dp),
                            onClick = {
                                navController.navigate("reader/${item.id}") },
                            modifier = Modifier.padding(1.dp)
                        ) {
                            Text(text = "$index")

                        }

                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )

        }


    }
}



