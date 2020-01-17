package ir.saatgroup.digikala.data.pojo

data class IncredibleProduct(
    val Id: Int,
    val ProductId: Int,
    val Title: String,
    val Discount: Int,
    val Price: Int,
    val OnlyForMembers: Boolean,
    val OnlyForApplication: Boolean,
    val IsFresh: Boolean,
    val ImagePaths: ImagePaths
)