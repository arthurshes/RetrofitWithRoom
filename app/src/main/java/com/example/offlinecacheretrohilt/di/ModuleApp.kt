package com.example.offlinecacheretrohilt.di


import android.app.Application
import androidx.room.Room
import com.example.offlinecacheretrohilt.db.MainDb
import com.example.offlinecacheretrohilt.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object ModuleApp{
    @Provides
    @Singleton
    fun provideRetrofit():Retrofit=
        Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit):ApiService{
    return  retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(app:Application):MainDb=
        Room.databaseBuilder(app,MainDb::class.java,"resto.db").build()
}