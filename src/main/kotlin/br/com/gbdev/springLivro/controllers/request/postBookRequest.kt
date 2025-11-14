package br.com.gbdev.springLivro.controllers.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import java.math.BigInteger

data class postBookRequest(
    val title: String,
    val author: String,
    val price: BigDecimal,
    @JsonAlias("customer_id")
    val customerId: Int
)
