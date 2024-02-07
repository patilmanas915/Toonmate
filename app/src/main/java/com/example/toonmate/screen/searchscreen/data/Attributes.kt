package com.example.toonmate.screen.searchscreen.data

data class Attributes(
    val altTitles: List<AltTitle>,
    val availableTranslatedLanguages: List<String>,
    val chapterNumbersResetOnNewVolume: Boolean,
    val contentRating: String,
    val createdAt: String,
    val description: Description,
    val isLocked: Boolean,
    val lastChapter: String,
    val lastVolume: String,
    val latestUploadedChapter: String,
    val links: Links,
    val originalLanguage: String,
    val publicationDemographic: String,
    val state: String,
    val status: String,
    val tags: List<Tag>,
    val title: Title,
    val updatedAt: String,
    val version: Int,
    val year: Int
)