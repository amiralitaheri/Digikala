package ir.saatgroup.digikala.data.pojo


data class Banner(
    val Id: String,
    val BannerId:String,
    val BannerType: String,
    val BannerPathMobile: String,
    val PatternImagePath: String,
    val BannerPathTablet: String,
    val Height:Int,
    val Width:Int,
    val Title: String,
    val LinkType: String,
    val LinkValue: String,
    val StartDateTime: String,
    val EndDateTime: String,
    val CampaignId: String
)