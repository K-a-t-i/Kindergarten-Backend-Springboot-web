package de.kati.bookstore.customer

    data class CustomerRequestDTO(
            val customerId: Int?,
            val firstName: String,
            val lastName: String,
            val email: String,
    )
