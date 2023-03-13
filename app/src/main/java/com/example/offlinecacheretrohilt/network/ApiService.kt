package com.example.offlinecacheretrohilt.network

import com.example.offlinecacheretrohilt.db.Restoran
import retrofit2.http.GET

interface ApiService {
 companion object{
     const val BASE_URL="https://random-data-api.com/api/"
 }
@GET("restaurant/random_restaurant?size=20")
suspend fun getRestaur():List<Restoran>
}