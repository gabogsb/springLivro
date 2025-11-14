package br.com.gbdev.springLivro.controllers

import br.com.gbdev.springLivro.controllers.request.postCustomerRequest
import br.com.gbdev.springLivro.controllers.request.putCustomerRequest
import br.com.gbdev.springLivro.extension.toCustomerModel
import br.com.gbdev.springLivro.models.customerModel
import br.com.gbdev.springLivro.services.customerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/customer")
class customerController(
  val customerService: customerService
){

  @GetMapping
  fun getAllCustomer(
    @RequestParam(required = false, defaultValue = "") name: String,
  ): List<customerModel> {
    return customerService.getAllCustomer(name)
  }

  @GetMapping("/{id}")
  fun getCustomer(@PathVariable id: Int): customerModel? {
    return customerService.getCustomer(id)
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  fun createCustomer(
    @RequestBody customerModel: postCustomerRequest
  ) {
    customerService.createCustomer(customerModel.toCustomerModel())
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun putCustomer(
    @PathVariable id: Int,
    @RequestBody customerModel: putCustomerRequest
  ) {
    customerService.putCustomer(customerModel.toCustomerModel(id))
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun deleteCustomer(
    @PathVariable id: Int,
  ) {
    customerService.deleteCustomer(id)
  }

}