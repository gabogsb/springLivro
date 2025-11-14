package br.com.gbdev.springLivro.extension

import br.com.gbdev.springLivro.controllers.request.postBookRequest
import br.com.gbdev.springLivro.controllers.request.postCustomerRequest
import br.com.gbdev.springLivro.controllers.request.putBookRequest
import br.com.gbdev.springLivro.controllers.request.putCustomerRequest
import br.com.gbdev.springLivro.enums.bookStatus
import br.com.gbdev.springLivro.models.bookModel
import br.com.gbdev.springLivro.models.customerModel

fun postCustomerRequest.toCustomerModel(): customerModel {
  return customerModel(
    name = this.name,
    email = this.email
  )
}

fun putCustomerRequest.toCustomerModel(id: Int): customerModel {
  return customerModel(
    id = id,
    name = this.name,
    email = this.email
  )
}

fun postBookRequest.toBookModel(customer: customerModel): bookModel {
  return bookModel(
    title = this.title,
    author = this.author,
    price = this.price,
    status = bookStatus.ATIVO,
    customer = customer
  )
}

fun putBookRequest.toBookModel(previousBook: bookModel?): bookModel {
  return bookModel(
    id = previousBook!!.id,
    title = this.title ?: previousBook.title,
    author = this.author ?: previousBook.author,
    price = this.price ?: previousBook.price,
    status = previousBook.status,
    customer = previousBook.customer
  )
}