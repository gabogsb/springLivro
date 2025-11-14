package br.com.gbdev.springLivro.services

import br.com.gbdev.springLivro.models.customerModel
import br.com.gbdev.springLivro.repositories.customerRepository
import org.springframework.stereotype.Service

@Service
class customerService(
  val customerRepository: customerRepository
) {

  val customers = mutableListOf<customerModel>()

  fun getAllCustomer(
    name: String?,
  ): List<customerModel> {
    name?.let {
      return customers.filter { it.name.contains(name, true) }
    }
    return customers
  }

  fun getCustomer(id: Int): customerModel {
    return customerRepository.findById(id).orElseThrow()
  }

  fun createCustomer(
    customerModel: customerModel
  ) {
    customerRepository.save(customerModel)
  }

  fun putCustomer(
    customerModel: customerModel
  ) {
    if (!customerRepository.existsById(customerModel.id!!)) {
      throw Exception()
    }
    customerRepository.save(customerModel)
  }

  fun deleteCustomer(id: Int) {
    customers.removeIf { it.id == id }
  }

}