package ir.saatgroup.digikala.utils.retrofit.models

import ir.saatgroup.digikala.data.pojo.IncredibleProduct

data class IncredibleModel(
    var Data:List<IncredibleProduct>,
    var Status: String, var Message: Any?
)