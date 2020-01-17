package ir.saatgroup.digikala.utils.retrofit

import ir.saatgroup.digikala.utils.retrofit.models.*
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface DigikalaAPI {
    @GET("https://service2.digikala.com/api/Banner/GetBanner")
    suspend fun getSlider(@Query("bannerType") bannerType: String, @HeaderMap headerMap: Map<String, String> = RetrofitConfig.headers): BannerModel


    @GET("https://service2.digikala.com/api/Banner/GetMobileBanner")
    suspend fun getMobileBanners(@HeaderMap headerMap: Map<String, String> = RetrofitConfig.headers): MobileBannerModel

    @GET("https://service2.digikala.com/api/Category/GetMainMenu")
    suspend fun getMainMenu(@HeaderMap headerMap: Map<String, String> = RetrofitConfig.headers): MainMenuModel

    @GET("https://service2.digikala.com/api/Category/GetCategoryByPath")
    suspend fun getCategory(@Query("categoryPath") categoryPath: String, @HeaderMap headerMap: Map<String, String> = RetrofitConfig.headers): CategoryModel

    @GET("https://search.digikala.com/api2/Data/GetAllTopList?mobile=2")
    suspend fun getTopList(@HeaderMap headerMap: Map<String, String> = RetrofitConfig.headers): TopListModel

    @GET("https://search.digikala.com/api2/Data/GetAllTopList?mobile=2")
    suspend fun getTopListByCategory(@Query("category") category: String, @HeaderMap headerMap: Map<String, String> = RetrofitConfig.headers): TopListModel

}