package de.kati.bookstore.customer

data class CustomerDTO(
        val customerId: Int,
        val firstName: String,
        val lastName: String,
        val email: String,
) {
    companion object {
        fun from(customerEntity: CustomerEntity): CustomerDTO {
            return CustomerDTO(customerId = customerEntity.customerId, firstName = customerEntity.firstName, lastName = customerEntity.lastName, email = customerEntity.email)
        }
    }
}
