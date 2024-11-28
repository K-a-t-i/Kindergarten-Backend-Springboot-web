package de.kati.bookstore.book

import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {
    fun getAllBooks(): List<BookDTO> {
        val books = bookRepository.findAll()
        return books.map { BookDTO(bookId = it.bookId, title = it.title, isbn13 = it.isbn13, languageId = it.languageId, numberPages = it.numberPages, publicationDate = it.publicationDate, publisherID = it.publisherId)}
    }

    fun getBookById(bookId: Int): BookDTO {
        // TODO Clean Code
        val book = bookRepository.findById(bookId).orElseThrow { BookNotFoundException("book not found") }
        return BookDTO(bookId = book.bookId, title = book.title, isbn13 = book.isbn13, languageId = book.languageId, numberPages = book.numberPages, publicationDate = book.publicationDate, publisherID = book.publisherId)
    }

    fun createBook(bookRequest: BookRequestDTO): BookDTO {
        val newBook = BookEntity(
                title = bookRequest.title,
                isbn13 = bookRequest.isbn13,
                languageId = bookRequest.languageId,
                numberPages = bookRequest.numberPages,
                publicationDate = bookRequest.publicationDate,
                publisherId = bookRequest.publisherID)
        return BookDTO.from(bookRepository.save(newBook))

    }

    fun updateBook(bookId: Int, bookDTO: BookRequestDTO): BookDTO {
        val existingBook = bookRepository.findById(bookId).orElseThrow { BookNotFoundException("Book not found") }
        val updatedBook = existingBook.copy(
                title = bookDTO.title,
                isbn13 = bookDTO.isbn13,
                languageId = bookDTO.languageId,
                numberPages = bookDTO.numberPages,
                publicationDate = bookDTO.publicationDate,
                publisherId = bookDTO.publisherID
        )
        val savedBook = bookRepository.save(updatedBook)
        return BookDTO.from(savedBook)
    }

    fun deleteBook(bookId: Int) {
        val existingBook = getBookfromDatabase(bookId)
        bookRepository.delete(existingBook)
    }

    private fun getBookfromDatabase(bookId: Int): BookEntity =
            bookRepository.findById(bookId).orElseThrow { BookNotFoundException("Book not found") }
}
