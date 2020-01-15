package ir.saatgroup.digikala.utils.retrofit.models

import ir.saatgroup.digikala.data.pojo.Category

data class CategoryModel(
    val Data: List<Category> = listOf(),
    val Status: String = "",
    val Message: Any = Any()
)