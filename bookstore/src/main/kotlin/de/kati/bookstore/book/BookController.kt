package de.kati.bookstore.book

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BookController(val bookService: BookService) {
    @GetMapping("/book")
    fun findAllBooks(): List<BookDTO> {
        return bookService.getAllBooks()
    }

    @GetMapping("/book/{id}")
    fun findOneById(@PathVariable id: Int): BookDTO {
        return bookService.getBookById(id)
    }

    @PostMapping("/book")
    fun createBook(@RequestBody book: BookRequestDTO): ResponseEntity<BookDTO> {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(book))
    }

    @DeleteMapping("/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Int) {
        bookService.deleteBook(id)
    }

    @PutMapping("/book/{id}")
    fun updateBook(@PathVariable id: Int, @RequestBody book: BookRequestDTO): BookDTO {
        return bookService.updateBook(id, book)
    }

}
