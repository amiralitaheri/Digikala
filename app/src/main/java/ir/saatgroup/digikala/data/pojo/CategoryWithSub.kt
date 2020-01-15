package ir.saatgroup.digikala.data.pojo

data class CategoryWithSub(
    val Category: Category,
    val SubCategory: List<Category> = listOf()
)