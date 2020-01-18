package ir.saatgroup.digikala.utils.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val DigikalaAPIClient by lazy {
    Retrofit.Builder()
        .baseUrl("https://digikala.com/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build().create(DigikalaAPI::class.java)
}