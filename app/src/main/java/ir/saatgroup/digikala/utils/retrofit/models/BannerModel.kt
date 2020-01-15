package ir.saatgroup.digikala.utils.retrofit.models

import ir.saatgroup.digikala.data.pojo.Banner

data class BannerModel(
    val Data: List<Banner> = listOf(),
    val Message: Any = Any(),
    val Status: String = ""
)