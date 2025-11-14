package br.com.gbdev.springLivro.controllers.request

import br.com.gbdev.springLivro.models.customerModel

data class postCustomerRequest(
  var name: String,
  var email: String
)