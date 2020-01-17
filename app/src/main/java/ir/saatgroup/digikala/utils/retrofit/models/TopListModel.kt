package ir.saatgroup.digikala.utils.retrofit.models

import ir.saatgroup.digikala.data.pojo.Product

data class TopListModel(var responses: List<Response>)
data class Response(var hits: Hits)
data class Hits(var hits: List<Hit>)
data class Hit(var _id: Int, var _source: Product)