package ir.saatgroup.digikala.data.repository

import ir.saatgroup.digikala.data.pojo.Banner
import ir.saatgroup.digikala.interfaces.BannerDao

class BannerRepository(private val bannerDao: BannerDao) {
    companion object {
        @Volatile
        private var instance: BannerRepository? = null

        fun getInstance(bannerDao: BannerDao) = instance ?: synchronized(this) {
            instance ?: BannerRepository(bannerDao).also { instance = it }
        }
    }

    fun getSlider(): List<Banner> {
        return bannerDao.getSlider()
    }
    fun getAdv(): List<Banner> {
        return bannerDao.getAdvBanners()
    }
    fun getMobile(): List<List<Banner>> {
        return bannerDao.getMobileBanners()
    }
}