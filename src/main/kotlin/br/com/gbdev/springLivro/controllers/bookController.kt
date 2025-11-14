package br.com.gbdev.springLivro.controllers

import br.com.gbdev.springLivro.controllers.request.postBookRequest
import br.com.gbdev.springLivro.controllers.request.putBookRequest
import br.com.gbdev.springLivro.extension.toBookModel
import br.com.gbdev.springLivro.models.bookModel
import br.com.gbdev.springLivro.services.bookService
import br.com.gbdev.springLivro.services.customerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/books")
class bookController(
  val bookService: bookService,
  val customerService: customerService
) {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  fun createBook(
    @RequestBody request: postBookRequest,
  ) {
    val customer = customerService.getCustomerById(request.customerId)
    bookService.createBook(request.toBookModel(customer))
  }

  @GetMapping
  fun getAllBooks() = bookService.getAllBooks()

  @GetMapping("/active")
  fun getAllActiveBooks() = bookService.getAllActiveBooks()

  @GetMapping("/{id}")
  fun getBookById(@PathVariable id: Int): bookModel? {
    return bookService.getBookById(id)
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun deleteBook(@PathVariable id: Int) = bookService.deleteBook(id)

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun updateBook(
    @PathVariable id: Int,
    @RequestBody book: putBookRequest,
  ) {
    val bookSaved = bookService.getBookById(id)
    bookService.updateBook(book.toBookModel(bookSaved))
  }


}