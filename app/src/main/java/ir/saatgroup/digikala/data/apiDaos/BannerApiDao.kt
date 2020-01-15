package ir.saatgroup.digikala.data.apiDaos

import ir.saatgroup.digikala.data.pojo.Banner
import ir.saatgroup.digikala.interfaces.BannerDao
import ir.saatgroup.digikala.utils.retrofit.DigikalaAPI
import ir.saatgroup.digikala.utils.retrofit.DigikalaAPIClient
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


class BannerApiDao : BannerDao {
    val digikalaAPI: DigikalaAPI = DigikalaAPIClient

    override fun getSlider(): List<Banner> {
        return runBlocking {
            return@runBlocking async { digikalaAPI.getSlider("Slider") }.await().Data
        }
    }

    override suspend fun getMainBanners(): List<Banner> {
        return runBlocking {
            return@runBlocking async { digikalaAPI.getMobileBanners() }.await().Data

        }
    }

    override suspend fun getAdvBanners(): List<Banner> {
        return runBlocking {
            return@runBlocking async { digikalaAPI.getSlider("Advertisement") }.await().Data
        }
    }

}