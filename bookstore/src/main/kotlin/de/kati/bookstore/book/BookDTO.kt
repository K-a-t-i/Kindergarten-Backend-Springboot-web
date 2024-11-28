package de.kati.bookstore.book

import java.util.*

data class BookDTO(
        val bookId: Int,
        val title: String,
        val isbn13: String,
        val languageId: Int,
        val numberPages: Int,
        val publicationDate: Date,
        val publisherID: Int,
) {
    companion object {
        fun from(bookEntity: BookEntity): BookDTO {
            return BookDTO(bookId = bookEntity.bookId,
                    title = bookEntity.title,
                    isbn13 = bookEntity.isbn13,
                    languageId = bookEntity.languageId,
                    numberPages = bookEntity.numberPages,
                    publicationDate = bookEntity.publicationDate,
                    publisherID = bookEntity.publisherId)
        }
    }
}


