package br.com.gbdev.springLivro.repositories

import br.com.gbdev.springLivro.models.customerModel
import org.springframework.data.repository.CrudRepository

interface customerRepository: CrudRepository<customerModel, Int> {

  fun findByNameContaining(name: String): List<customerModel>

}