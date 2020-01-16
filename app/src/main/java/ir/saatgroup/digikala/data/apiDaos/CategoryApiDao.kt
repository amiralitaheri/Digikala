package ir.saatgroup.digikala.data.apiDaos

import ir.saatgroup.digikala.data.pojo.Category
import ir.saatgroup.digikala.data.pojo.CategoryWithSub
import ir.saatgroup.digikala.interfaces.CategoryDao
import ir.saatgroup.digikala.utils.retrofit.DigikalaAPI
import ir.saatgroup.digikala.utils.retrofit.DigikalaAPIClient
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

object CategoryApiDao : CategoryDao {
    val digikalaAPI: DigikalaAPI = DigikalaAPIClient

    override fun getMainCategories(): List<CategoryWithSub> {
        return runBlocking {
            return@runBlocking async { digikalaAPI.getMainMenu() }.await().Data
        }
    }

    override fun getChildren(categoryPath: String): List<Category> {
        return runBlocking {
            return@runBlocking async { digikalaAPI.getCategory(categoryPath) }.await().Data
        }
    }

}