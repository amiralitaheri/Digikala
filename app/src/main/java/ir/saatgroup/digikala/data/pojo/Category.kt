package ir.saatgroup.digikala.data.pojo

data class Category(
    val Id: Int,
    val Title: String,
    val ImagePath: String,
    val UrlCode: String,
    val HasMainPage: Boolean,
    val QueryStringValue: String
)