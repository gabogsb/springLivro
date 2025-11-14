package br.com.gbdev.springLivro.services

import br.com.gbdev.springLivro.controllers.request.postCustomerRequest
import br.com.gbdev.springLivro.controllers.request.putCustomerRequest
import br.com.gbdev.springLivro.models.customerModel
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus

@Service
class customerService {

  val customers = mutableListOf<customerModel>()

  fun getAllCustomer(
    name: String?,
  ): List<customerModel> {
    name?.let {
      return customers.filter { it.name.contains(name, true) }
    }
    return customers
  }

  fun getCustomer(id: String): customerModel? {

    return customers.firstOrNull { it.id == id }

//    val customer = customers.firstOrNull { it.id == id }
//    if (customer != null) {
//      return customer
//    } else {
//      return null
//    }
  }

  fun createCustomer(
    customerModel: customerModel
  ) {

    val id = if (customers.isEmpty()) {
      "1"
    } else {
      customers.last().id.toInt() + 1
    }.toString()

    customers.add(customerModel)
    println(customerModel)
  }

  fun putCustomer(
    id: String,
    customerModel: putCustomerRequest
  ) {
    return customers.firstOrNull { it.id == id }.let {
      it?.name = customerModel.name
      it?.email = customerModel.email
    }
  }

  fun deleteCustomer(id: String) {
    customers.removeIf { it.id == id }
  }

}