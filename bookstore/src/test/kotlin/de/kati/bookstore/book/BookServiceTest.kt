package de.kati.bookstore.book

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.slot
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

class BookServiceTest {
    private lateinit var bookService: BookService

    @MockK
    private lateinit var bookRepository: BookRepository

    @BeforeEach
    fun setUp(){
        MockKAnnotations.init(this)
        bookService = BookService(bookRepository)
    }

    @Test
    fun `Should return list of books when available in db`() {
        every { bookRepository.findAll() } returns standardBooks()

        val books = bookService.getAllBooks()

        assertThat(books).hasSize(5)
    }

    @Test
    fun `Should throw error when book is not available`() {

        every { bookRepository.findById(any()) } returns Optional.empty()

        assertThrows<BookNotFoundException> { bookService.getBookById(6) }
    }

    @Test
    fun `Should save book in database when book is valid`() {
        val bookDTO = BookRequestDTO(
                title = "Sample Book",
                isbn13 = "9781234567890",
                languageId = 1,
                numberPages = 200,
                publicationDate = Date(),
                publisherID = 101
        )

        val bookEntity = BookEntity(
                bookId = 0,
                title = "Sample Book",
                isbn13 = "9781234567890",
                languageId = 1,
                numberPages = 200,
                publicationDate = Date(),
                publisherId = 101
        )

        val slot = slot<BookEntity>()

        every { bookRepository.save(any()) } returns bookEntity
        bookService.createBook(bookDTO)
        verify { bookRepository.save(capture(slot)) }

        assertThat(slot.isCaptured).isTrue
        assertThat(slot.captured.bookId).isEqualTo(0)

        }

    private fun standardBooks(): List<BookEntity> {
        return listOf(
                BookEntity(
                        bookId = 1,
                        title = "Harry Potter and the Sorcerer's Stone",
                        isbn13 = "9780590353403",
                        languageId = 1,
                        numberPages = 320,
                        publicationDate = Date(),
                        publisherId = 101
                ),
                BookEntity(
                        bookId = 2,
                        title = "To Kill a Mockingbird",
                        isbn13 = "9780061120084",
                        languageId = 2,
                        numberPages = 281,
                        publicationDate = Date(),
                        publisherId = 102
                ),
                BookEntity(
                        bookId = 3,
                        title = "1984",
                        isbn13 = "9780451524935",
                        languageId = 3,
                        numberPages = 328,
                        publicationDate = Date(),
                        publisherId = 103
                ),
                BookEntity(
                        bookId = 4,
                        title = "The Great Gatsby",
                        isbn13 = "9780743273565",
                        languageId = 1,
                        numberPages = 180,
                        publicationDate = Date(),
                        publisherId = 104
                ),
                BookEntity(
                        bookId = 5,
                        title = "Pride and Prejudice",
                        isbn13 = "9780486284736",
                        languageId = 4,
                        numberPages = 320,
                        publicationDate = Date(),
                        publisherId = 105
                )
        )
    }
}
