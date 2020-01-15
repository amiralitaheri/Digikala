package ir.saatgroup.digikala.interfaces

import ir.saatgroup.digikala.data.pojo.Category
import ir.saatgroup.digikala.data.pojo.CategoryWithSub

interface CategoryDao {
    fun getMainCategories(): List<CategoryWithSub>
    fun getChildren(categoryPath: String): List<Category>
}