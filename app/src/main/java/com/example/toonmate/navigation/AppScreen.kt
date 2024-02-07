package com.example.toonmate.navigation

sealed class AppScreen(val route:String) {
    object Download:AppScreen("download")
    object Fav:AppScreen("fav")
    object Search:AppScreen("search")
    object Comic:AppScreen("comic")
    object Reader:AppScreen("reader")
}