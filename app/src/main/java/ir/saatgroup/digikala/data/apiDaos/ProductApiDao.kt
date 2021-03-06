package ir.saatgroup.digikala.data.apiDaos

import ir.saatgroup.digikala.data.pojo.IncredibleProduct
import ir.saatgroup.digikala.data.pojo.Product
import ir.saatgroup.digikala.interfaces.ProductDao
import ir.saatgroup.digikala.utils.retrofit.DigikalaAPI
import ir.saatgroup.digikala.utils.retrofit.DigikalaAPIClient
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

object ProductApiDao : ProductDao {

    val digikalaAPI: DigikalaAPI = DigikalaAPIClient

    override fun getTopSellers(): List<Product> {
        return runBlocking {
            val out = mutableListOf<Product>()
            val res = async { digikalaAPI.getTopList() }.await()
            for (item in res.responses[0].hits.hits) {
                out.add(item._source)
            }
            return@runBlocking out
        }
    }

    override fun getNewest(): List<Product> {
        return runBlocking {
            val out = mutableListOf<Product>()
            val res = async { digikalaAPI.getTopList() }.await()
            for (item in res.responses[1].hits.hits) {
                out.add(item._source)
            }
            return@runBlocking out
        }
    }

    override fun getTopListByCategory(category: String): List<Product> {
        return runBlocking {
            val out = mutableListOf<Product>()
            val res = async { digikalaAPI.getTopListByCategory(category) }.await()
            for (item in res.responses[0].hits.hits) {
                out.add(item._source)
            }
            return@runBlocking out
        }


    }

    override fun getIncredibleOffers(): List<IncredibleProduct> {
        return runBlocking {
            return@runBlocking async { digikalaAPI.getIncrdibleOffers() }.await().Data
        }
    }
}