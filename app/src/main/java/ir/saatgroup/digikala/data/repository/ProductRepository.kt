package ir.saatgroup.digikala.data.repository

import ir.saatgroup.digikala.data.pojo.IncredibleProduct
import ir.saatgroup.digikala.data.pojo.Product
import ir.saatgroup.digikala.interfaces.ProductDao

class ProductRepository(private val productDao: ProductDao) {

    companion object {
        @Volatile
        private var instance: ProductRepository? = null

        fun getInstance(productDao: ProductDao) = instance ?: synchronized(this) {
            instance ?: ProductRepository(productDao).also { instance = it }
        }

    }

    fun getTopSellers(): List<Product> {
        return productDao.getTopSellers()
    }

    fun getIncredibleOffers(): List<IncredibleProduct> = productDao.getIncredibleOffers()
}