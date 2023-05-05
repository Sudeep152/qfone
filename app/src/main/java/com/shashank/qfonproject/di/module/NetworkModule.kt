package com.shashank.qfonproject.di.module

import com.shashank.qfonproject.data.api.AirewaysAPI
import com.shashank.qfonproject.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {



    @Singleton
    @Provides
    fun  provideRetrofitClient():Retrofit.Builder{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
    }


    @Singleton
    @Provides
    fun provideOkHttpClient():OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    }
    @Singleton
    @Provides
    fun  provideAirwaysApi(retrofitBuilder:Retrofit.Builder,okHttpClient: OkHttpClient):AirewaysAPI{
       return retrofitBuilder.client(okHttpClient).build().create(AirewaysAPI::class.java)
    }




}