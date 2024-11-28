package de.kati.bookstore.customer

import de.kati.bookstore.book.BookEntity
import jakarta.persistence.*

@Entity
@Table(name = "customer")
data class CustomerEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val customerId: Int = 0,

        @Column(name = "first_name")
        val firstName: String,

        @Column(name = "last_name")
        val lastName: String,

        @Column(name = "email")
        val email: String,

        @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
        val borrowedBooks: List<BookEntity> = mutableListOf()
)

