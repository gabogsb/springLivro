package br.com.gbdev.springLivro.controllers.request

import java.math.BigDecimal

data class putBookRequest(
    val title: String?,
    val author: String?,
    val price: BigDecimal?
)
