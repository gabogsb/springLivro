package br.com.gbdev.springLivro.repositories

import br.com.gbdev.springLivro.enums.bookStatus
import br.com.gbdev.springLivro.models.bookModel
import br.com.gbdev.springLivro.models.customerModel
import org.springframework.data.repository.CrudRepository

interface bookRepository: CrudRepository<bookModel, Int> {

  fun findByStatus(status: bookStatus): List<bookModel>

}