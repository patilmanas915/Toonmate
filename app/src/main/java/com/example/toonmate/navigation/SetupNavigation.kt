package com.example.toonmate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.toonmate.screen.comicscreen.ComicScreen
import com.example.toonmate.screen.favscreen.Favscreen
import com.example.toonmate.screen.homescreen.downloadscreen
import com.example.toonmate.screen.readerscreen.Readerscreen
import com.example.toonmate.screen.searchscreen.SearchScreen

@Composable
fun SetupNavigation(navHostController: NavHostController, modifier: Modifier){
     NavHost(navController =navHostController , startDestination = AppScreen.Fav.route){
         composable(AppScreen.Download.route){
             downloadscreen(navController =navHostController)
         }
         composable(AppScreen.Fav.route){
             Favscreen(navController =navHostController)
         }
         composable(AppScreen.Search.route){
             SearchScreen(navController =navHostController)
         }
         composable(AppScreen.Comic.route){
             ComicScreen(navController =navHostController)
         }
         composable(AppScreen.Reader.route){
             Readerscreen(navController =navHostController)
         }

     }

}