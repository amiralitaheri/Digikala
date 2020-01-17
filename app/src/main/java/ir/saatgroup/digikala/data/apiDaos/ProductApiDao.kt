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
            var out = mutableListOf<Product>()
            val res = async { digikalaAPI.getTopList() }.await()
            for (item in res.responses[0].hits.hits) {
                out.add(item._source)
            }
            return@runBlocking out
        }
    }

    override fun getNewest(): List<Product> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTopListByCategory(): List<Product> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getIncredibleOffers(): List<IncredibleProduct> {
        return runBlocking {
            return@runBlocking async { digikalaAPI.getIncrdibleOffers() }.await().Data
        }
    }
}