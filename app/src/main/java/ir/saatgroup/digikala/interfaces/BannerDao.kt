package ir.saatgroup.digikala.interfaces

import ir.saatgroup.digikala.data.pojo.Banner

interface BannerDao {
    fun getSlider(): List<Banner>
    fun getMainBanners(): List<Banner>
    fun getAdvBanners(): List<Banner>
}