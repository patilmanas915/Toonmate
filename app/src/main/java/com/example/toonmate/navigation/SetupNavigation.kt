package com.example.toonmate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.toonmate.screen.readerscreen.ComicScreen
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
         composable(route="reader/{id}", arguments = listOf(
             navArgument("id"){
                 type= NavType.StringType
             }
         )){
             val id = it.arguments?.getString("id") ?: ""
             Readerscreen(navController =navHostController,id)
         }
         composable(
             route = "comic/{my_param}/{name}/{url}",
             arguments = listOf(
                 navArgument("my_param") {
                     type = NavType.StringType
                 },
                 navArgument("name") {
                     type = NavType.StringType
                 },
                 navArgument("url") {
                     type = NavType.StringType
                 },
             )
         ) {
             val id = it.arguments?.getString("my_param") ?: ""
             val name=it.arguments?.getString("name")?:""
             val url=it.arguments?.getString("url")?:""
            ComicScreen(navController = navHostController, id =id ,name,url)
         }

     }

}