package br.com.gbdev.springLivro.extension

import br.com.gbdev.springLivro.controllers.request.postCustomerRequest
import br.com.gbdev.springLivro.models.customerModel

fun postCustomerRequest.toCustomerModel(): customerModel {
  return customerModel(
    name = this.name,
    email = this.email
  )
}