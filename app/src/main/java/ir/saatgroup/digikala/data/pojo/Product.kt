package ir.saatgroup.digikala.data.pojo

data class Product(
    val Id: Int,
    val FaTitle: String,
    val EnTitle: String,
    val MinPrice: Int,
    val MinPriceList: Int,
    val IsSpecialOffer: Boolean,
    val ExistStatus: Int,
    val Rate: Int,
    val UserRating: Int,
    val LikeCounter: Int,
    val ImagePath: String,
    val ShowType: Int,
    val Brand: Brand,
    val IsFresh: Boolean,
    val IsSponsoredOffer: Boolean,
    val IsFake:Boolean
) {
    val ProductColorList: MutableList<Color> = mutableListOf()
}