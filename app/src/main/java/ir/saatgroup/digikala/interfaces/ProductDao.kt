package ir.saatgroup.digikala.interfaces

import ir.saatgroup.digikala.data.pojo.Product

interface ProductDao {
    fun getTopSellers() : List<Product>
    fun getNewest(): List<Product>
    fun getTopListByCategory():List<Product>
}