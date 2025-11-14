package br.com.gbdev.springLivro.services

import br.com.gbdev.springLivro.models.customerModel
import br.com.gbdev.springLivro.repositories.customerRepository
import org.springframework.stereotype.Service

@Service
class customerService(
  val customerRepository: customerRepository
) {

  fun getAllCustomer(
    name: String?,
  ): List<customerModel> {
    name?.let {
      return customerRepository.findByNameContaining(it)
    }
    return customerRepository.findAll().toList()

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
    if (!customerRepository.existsById(id)) {
      throw Exception()
    }
    customerRepository.deleteById(id)

  }

}