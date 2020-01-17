package ir.saatgroup.digikala.utils.retrofit.models

import ir.saatgroup.digikala.data.pojo.Banner

data class MobileBannerModel(
    val Data: List<List<Banner>> = listOf(),
    val Message: Any = Any(),
    val Status: String = ""
)



