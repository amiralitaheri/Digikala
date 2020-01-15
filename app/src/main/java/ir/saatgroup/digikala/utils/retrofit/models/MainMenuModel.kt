package ir.saatgroup.digikala.utils.retrofit.models

import ir.saatgroup.digikala.data.pojo.CategoryWithSub

data class MainMenuModel(
    val Data:List<CategoryWithSub> = listOf(),
    val Status: String = "",
    val Message: Any = Any()
)
