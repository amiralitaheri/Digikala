package ir.saatgroup.digikala.interfaces

import ir.saatgroup.digikala.data.pojo.Banner

interface BannerDao {
    fun getSlider(): List<Banner>
    suspend fun getMainBanners(): List<Banner>
    suspend fun getAdvBanners(): List<Banner>
}