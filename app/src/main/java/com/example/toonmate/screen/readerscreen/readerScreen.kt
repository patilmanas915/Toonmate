package com.example.toonmate.screen.readerscreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.example.toonmate.R
import com.example.toonmate.screen.searchscreen.SearchCard
import com.example.toonmate.ui.theme.ToonmateTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Readerscreen(navController: NavController,modifier: Modifier = Modifier) {
    var isTopBarVisible by remember { mutableStateOf(false) }
    var orientation by remember { mutableStateOf(true) }

    val scope = rememberCoroutineScope()
    val imageLinks = listOf(
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/1-f7a76de10d346de7ba01786762ebbedc666b412ad0d4b73baa330a2a392dbcdd.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/2-2a5e95dfec7f15cd01f9a63835be18a22fb77a10fd2d62858c7dcbb6e6c622f9.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/3-d06c6f764fdc3c76ea7ae3b76493fdf1a32b8926f2b60ed207b5c2fed13d002e.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/4-a614d6456b9b13931bc5c5ef23cb5f744671f0e1e08c7335682a32de78482f71.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/5-1105a368fd73ae99a06d7aebd165a1ff4322539ba50022a967f7b5fb0a185ce5.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/6-e8a3eac12d879c541c4a36da550d2c69cc9450cb9b1840a079f890facf5f0c89.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/1-f7a76de10d346de7ba01786762ebbedc666b412ad0d4b73baa330a2a392dbcdd.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/2-2a5e95dfec7f15cd01f9a63835be18a22fb77a10fd2d62858c7dcbb6e6c622f9.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/3-d06c6f764fdc3c76ea7ae3b76493fdf1a32b8926f2b60ed207b5c2fed13d002e.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/4-a614d6456b9b13931bc5c5ef23cb5f744671f0e1e08c7335682a32de78482f71.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/5-1105a368fd73ae99a06d7aebd165a1ff4322539ba50022a967f7b5fb0a185ce5.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/6-e8a3eac12d879c541c4a36da550d2c69cc9450cb9b1840a079f890facf5f0c89.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/1-f7a76de10d346de7ba01786762ebbedc666b412ad0d4b73baa330a2a392dbcdd.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/2-2a5e95dfec7f15cd01f9a63835be18a22fb77a10fd2d62858c7dcbb6e6c622f9.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/3-d06c6f764fdc3c76ea7ae3b76493fdf1a32b8926f2b60ed207b5c2fed13d002e.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/4-a614d6456b9b13931bc5c5ef23cb5f744671f0e1e08c7335682a32de78482f71.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/5-1105a368fd73ae99a06d7aebd165a1ff4322539ba50022a967f7b5fb0a185ce5.png",
        "https://uploads.mangadex.org/data/3303dd03ac8d27452cce3f2a882e94b2/6-e8a3eac12d879c541c4a36da550d2c69cc9450cb9b1840a079f890facf5f0c89.png"
    )
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        imageLinks.size
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(
                onLongPress = { },
                onTap = { isTopBarVisible = !isTopBarVisible }
            )

        }
    )
    {
        if(orientation) {
            Box(modifier.align(Alignment.Center)) {


                HorizontalPager(
                    state = pagerState,
                    key = { imageLinks[it] }) {
                    SubcomposeAsyncImage(
                        modifier = Modifier.fillMaxWidth(),
                        model = imageLinks[it],
                        contentDescription = imageLinks[it],
                        loading = {
                            Box(
                                modifier = modifier
                                    .size(40.dp)
                                    .align(Alignment.Center)
                            ) {
                                CircularProgressIndicator(modifier.align(Alignment.Center))
                            }

                        })

                }
            }
        } else {
            LazyColumn(content = {
                items(imageLinks){
                    SubcomposeAsyncImage(
                        modifier = Modifier.fillMaxWidth(),
                        model = it,
                        contentDescription = it,
                        loading = {
                            Box(
                                modifier = modifier
                                    .size(40.dp)
                                    .align(Alignment.Center)
                            ) {
                                CircularProgressIndicator(modifier.align(Alignment.Center))
                            }

                        })
                }
            })
        }

        if (isTopBarVisible) {
            TopAppBar(
                title = { Text(text = "Top Bar") },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding(),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray.copy(0.6f),
                    titleContentColor = Color.White
                )
            )
            BottomAppBar(
                containerColor = Color.Gray.copy(0.3f),
                contentColor = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .statusBarsPadding()
                    .fillMaxWidth()
            ) {
                IconButton(onClick = {
                    if (orientation){
                        scope.launch {
                            pagerState.animateScrollToPage(
                                pagerState.currentPage - 1
                            )

                        }
                    }


                }, modifier = Modifier.weight(1f)) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)


                }
                IconButton(onClick = {
                    orientation = !orientation
                }, modifier = Modifier.weight(1f)) {
                    if (orientation)
                        Icon(
                            painter = painterResource(id = R.drawable.vertical),
                            contentDescription = null
                        )
                    else
                        Icon(
                            painter = painterResource(id = R.drawable.horizontal),
                            contentDescription = null
                        )

                }
                IconButton(onClick = {
                    if (orientation){
                        scope.launch {
                            pagerState.animateScrollToPage(
                                pagerState.currentPage + 1
                            )

                        }

                    }

                }, modifier = Modifier.weight(1f)) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)

                }

            }

        }
    }
}
