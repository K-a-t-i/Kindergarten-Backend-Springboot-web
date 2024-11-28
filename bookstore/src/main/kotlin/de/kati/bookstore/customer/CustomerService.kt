package de.kati.bookstore.customer

import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepository) {
    fun getAllCustomers(): List<CustomerDTO> {
        // TODO Clean Code
        val customers = customerRepository.findAll()
        return customers.map { CustomerDTO.from(it) }
    }

    fun getCustomerById(customerId: Int): CustomerDTO {
        val customer = getCustomerfromDatabase(customerId)
        return CustomerDTO.from(customer)
    }

    fun createCustomer(customerRequest:CustomerRequestDTO): CustomerDTO {
        val newCustomer = CustomerEntity(firstName = customerRequest.firstName,
                lastName = customerRequest.lastName,
                email = customerRequest.email)
        val customer = customerRepository.save(newCustomer)
        return CustomerDTO.from(customer)
    }

    fun updateCustomer(customerId: Int, customerRequestDTO: CustomerRequestDTO): CustomerDTO {
        val existingCustomer = getCustomerfromDatabase(customerId)
        val updatedCustomer = existingCustomer.copy(
                firstName = customerRequestDTO.firstName,
                lastName = customerRequestDTO.lastName,
                email = customerRequestDTO.email
        )
        val savedCustomer = customerRepository.save(updatedCustomer)
        return CustomerDTO.from(savedCustomer)
    }

    fun deleteCustomer(customerId: Int) {
        val existingCustomer = getCustomerfromDatabase(customerId)
        customerRepository.delete(existingCustomer)
    }

    private fun getCustomerfromDatabase(customerId: Int): CustomerEntity =
            customerRepository.findById(customerId).orElseThrow { CustomerNotFoundException("Customer not found") }
}