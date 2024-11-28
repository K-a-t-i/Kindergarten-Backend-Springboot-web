package de.kati.bookstore.customer

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class CustomerController(val customerService: CustomerService) {
    @GetMapping("/customer")
    fun findAllCustomers(): List<CustomerDTO> {
        return customerService.getAllCustomers()
    }

    @GetMapping("/customer/{id}")
    fun findOneById(@PathVariable id: Int): CustomerDTO {
        return customerService.getCustomerById(id)
    }

    @PostMapping("/customer")
    fun createCustomer(@RequestBody customer: CustomerRequestDTO): ResponseEntity<CustomerDTO>{
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer))
    }

    @PutMapping("/customer/{id}")
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: CustomerRequestDTO): CustomerDTO {
        return customerService.updateCustomer(id, customer)
    }

    @DeleteMapping("/customer/{id}")
    fun deleteCustomer(@PathVariable id: Int): ResponseEntity<Unit> {
        customerService.deleteCustomer(id)
        return ResponseEntity.noContent().build()
    }
}
