package ir.saatgroup.digikala.interfaces

import ir.saatgroup.digikala.data.pojo.IncredibleProduct
import ir.saatgroup.digikala.data.pojo.Product

interface ProductDao {
    fun getTopSellers() : List<Product>
    fun getNewest(): List<Product>
    fun getIncredibleOffers():List<IncredibleProduct>
    fun getTopListByCategory(category: String): List<Product>
}