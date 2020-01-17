package ir.saatgroup.digikala.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.saatgroup.digikala.data.apiDaos.BannerApiDao
import ir.saatgroup.digikala.data.apiDaos.CategoryApiDao
import ir.saatgroup.digikala.data.apiDaos.ProductApiDao
import ir.saatgroup.digikala.data.pojo.Banner
import ir.saatgroup.digikala.data.pojo.CategoryWithSub
import ir.saatgroup.digikala.data.pojo.IncredibleProduct
import ir.saatgroup.digikala.data.pojo.Product
import ir.saatgroup.digikala.data.repository.BannerRepository
import ir.saatgroup.digikala.data.repository.CategoryRepository
import ir.saatgroup.digikala.data.repository.ProductRepository

class MainActivityViewModel : ViewModel() {
    private val bannerRepository = BannerRepository.getInstance(BannerApiDao)
    private val categoryRepository = CategoryRepository.getInstance(CategoryApiDao)
    private val productRepository = ProductRepository.getInstance(ProductApiDao)
    private var sliderBanners = MutableLiveData<List<Banner>>()
    private var catList = MutableLiveData<List<CategoryWithSub>>()
    private var advBanners = MutableLiveData<List<Banner>>()
    private var mobileBanners = MutableLiveData<List<List<Banner>>>()
    private var topSellers = MutableLiveData<List<Product>>()
    private var newest = MutableLiveData<List<Product>>()
    private var incredibleProducts = MutableLiveData<List<IncredibleProduct>>()

    fun getSliders(): LiveData<List<Banner>> {
        sliderBanners.value = bannerRepository.getSlider()
        return sliderBanners
    }

    fun getCategory(): LiveData<List<CategoryWithSub>> {
        catList.value = categoryRepository.getMainMenu()
        return catList
    }

    fun getAdvBanners(): LiveData<List<Banner>> {
        advBanners.value = bannerRepository.getAdv()
        return advBanners
    }

    fun getMobileBanners(): LiveData<List<List<Banner>>> {
        mobileBanners.value = bannerRepository.getMobile()
        return mobileBanners
    }

    fun getTopSellers(): LiveData<List<Product>> {
        topSellers.value = productRepository.getTopSellers()
        return topSellers
    }

    fun getIncredibleOffers(): LiveData<List<IncredibleProduct>> {
        incredibleProducts.value = productRepository.getIncredibleOffers()
        return incredibleProducts
    }

    fun getNewest(): LiveData<List<Product>> {
        newest.value = productRepository.getNewest()
        return newest
    }
    fun getAllTopByCategory(category:String):List<Product>{
        return productRepository.getAllTopByCategory(category)
    }

}