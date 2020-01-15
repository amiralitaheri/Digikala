package ir.saatgroup.digikala.interfaces

import ir.saatgroup.digikala.data.pojo.Category

interface CategoryDao {
    fun getMainCateogies(): List<Category>
    fun getChildren(categoryPath: String): List<Category>
}