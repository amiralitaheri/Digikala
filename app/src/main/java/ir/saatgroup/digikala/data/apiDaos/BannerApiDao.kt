package ir.saatgroup.digikala.data.apiDaos

import ir.saatgroup.digikala.data.pojo.Banner
import ir.saatgroup.digikala.interfaces.BannerDao
import ir.saatgroup.digikala.utils.retrofit.DigikalaAPI
import ir.saatgroup.digikala.utils.retrofit.DigikalaAPIClient
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


object BannerApiDao : BannerDao {

    val digikalaAPI: DigikalaAPI = DigikalaAPIClient

    override fun getSlider(): List<Banner> {
        return runBlocking {
            return@runBlocking async { digikalaAPI.getSlider("Slider") }.await().Data
        }
    }

    override fun getMobileBanners(): List<List<Banner>> {
        return runBlocking {
            return@runBlocking async { digikalaAPI.getMobileBanners() }.await().Data

        }
    }

    override fun getAdvBanners(): List<Banner> {
        return runBlocking {
            return@runBlocking async { digikalaAPI.getSlider("Advertisement") }.await().Data
        }
    }

}