package de.kati.bookstore.book

import java.util.Date

data class BookRequestDTO(
        val title: String,
        val isbn13: String,
        val languageId: Int,
        val numberPages: Int,
        val publicationDate: Date,
        val publisherID: Int
)