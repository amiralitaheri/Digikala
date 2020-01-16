package ir.saatgroup.digikala.data.repository

import ir.saatgroup.digikala.data.pojo.Category
import ir.saatgroup.digikala.data.pojo.CategoryWithSub
import ir.saatgroup.digikala.interfaces.CategoryDao

class CategoryRepository(private val categoryDao: CategoryDao) {
    companion object {
        @Volatile
        private var instance: CategoryRepository? = null

        fun getInstance(categoryDao: CategoryDao) = instance ?: synchronized(this) {
            instance ?: CategoryRepository(categoryDao).also { instance = it }
        }

    }

    lateinit var mainMenuCache: List<CategoryWithSub>
    var cached = false

    fun getMainMenu(): List<CategoryWithSub> {
        if (!cached) {
            mainMenuCache = categoryDao.getMainCategories()
            cached = true
        }
        return mainMenuCache
    }

    fun getChilern(path: String): List<Category> {
        return categoryDao.getChildren(path)
    }

}