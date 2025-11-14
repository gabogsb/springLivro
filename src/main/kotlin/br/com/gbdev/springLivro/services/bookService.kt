package br.com.gbdev.springLivro.services


import br.com.gbdev.springLivro.enums.bookStatus
import br.com.gbdev.springLivro.models.bookModel
import br.com.gbdev.springLivro.repositories.bookRepository
import org.springframework.stereotype.Service

@Service
class bookService(
  val bookRepository: bookRepository
) {
  fun createBook(book: bookModel) {
    bookRepository.save(book)
  }

  fun getAllBooks(): List<bookModel> {
    return bookRepository.findAll().toList()
  }

  fun getAllActiveBooks(): List<bookModel> {
    return bookRepository.findByStatus(bookStatus.ATIVO)
  }

  fun getBookById(id: Int): bookModel? {
    return bookRepository.findById(id).orElse(null)
  }

  fun updateBook(updatedBook: bookModel){
    val existingBook = getBookById(updatedBook.id!!)
    if (existingBook != null) {
      existingBook.title = updatedBook.title
      existingBook.author = updatedBook.author
      existingBook.status = updatedBook.status
      existingBook.price = updatedBook.price
      bookRepository.save(existingBook)
    } else {
      throw Exception("Livro não encontrado")
    }
  }

//  fun updateBook(book: bookModel){
//    bookRepository.save(book)
//  }

  fun deleteBook(id: Int) {
    val book = getBookById(id)
    if (book != null) {
      book.status = bookStatus.CANCELADO
      updateBook(book)
    } else {
      throw Exception("Livro não encontrado")
    }
  }

}
