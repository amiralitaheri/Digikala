package ir.saatgroup.digikala.utils.retrofit.models

import ir.saatgroup.digikala.data.pojo.Product

data class ProductModel(
    val Data: List<Product> = listOf(),
    val Message: Any = Any(),
    val Status: String = ""
)