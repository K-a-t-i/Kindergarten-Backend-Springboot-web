package de.kati.bookstore.book

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "book")
data class BookEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "book_id")
        val bookId: Int = 0,

        @Column(name = "title")
        val title: String,

        @Column(name = "isbn_13")
        val isbn13: String,

        @Column(name = "language_id")
        val languageId: Int,

        @Column(name = "number_pages")
        val numberPages: Int,

        @Column(name = "publication_date")
        val publicationDate: Date,

        @Column(name = "publisher_id")
        val publisherId: Int,

)
