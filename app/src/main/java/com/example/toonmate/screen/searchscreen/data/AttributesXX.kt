package com.example.toonmate.screen.searchscreen.data

data class AttributesXX(
    val altTitles: List<AltTitleX>,
    val availableTranslatedLanguages: List<String>,
    val chapterNumbersResetOnNewVolume: Boolean,
    val contentRating: String,
    val createdAt: String,
    val description: DescriptionXX,
    val isLocked: Boolean,
    val lastChapter: String,
    val lastVolume: String,
    val latestUploadedChapter: String,
    val links: LinksX,
    val originalLanguage: String,
    val publicationDemographic: String,
    val state: String,
    val status: String,
    val tags: List<TagX>,
    val title: TitleX,
    val updatedAt: String,
    val version: Int,
    val year: Int
)