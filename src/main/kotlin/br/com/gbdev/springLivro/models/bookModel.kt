package br.com.gbdev.springLivro.models

import br.com.gbdev.springLivro.enums.bookStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.math.BigDecimal
import java.util.Date

@Entity(name = "books")
data class bookModel(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int? = null,
  @Column
  var title: String,
  @Column
  var author: String,
  @Column
  var price: BigDecimal,
  @Column
  @Enumerated(EnumType.STRING)
  var status: bookStatus? = null,

  @ManyToOne
  @JoinColumn(name = "customer_id")
  var customer: customerModel? = null

)