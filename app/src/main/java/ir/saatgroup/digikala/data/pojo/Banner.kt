package ir.saatgroup.digikala.data.pojo

data class Banner(
    val Id: String,
    val BannerType: String,
    val PatternImagePath: String,
    val Title: String,
    val LinkType: String,
    val LinkValue: String,
    val campaignId: String
) {
}