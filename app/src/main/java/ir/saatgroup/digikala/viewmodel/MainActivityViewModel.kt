package ir.saatgroup.digikala.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.saatgroup.digikala.data.apiDaos.BannerApiDao
import ir.saatgroup.digikala.data.pojo.Banner
import ir.saatgroup.digikala.data.repository.BannerRepository

class MainActivityViewModel : ViewModel() {
    private val bannerRepository = BannerRepository.getInstance(BannerApiDao)
    private var sliderBanners = MutableLiveData<List<Banner>>()

    init {
        sliderBanners.value = listOf()
    }

    fun getSliders(): MutableLiveData<List<Banner>> {
        sliderBanners.value = bannerRepository.getSlider()
        return sliderBanners
    }
}