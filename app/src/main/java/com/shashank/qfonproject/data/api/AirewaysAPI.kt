package com.shashank.qfonproject.data.api


import com.shashank.qfonproject.data.model.Aireways
import retrofit2.Call

import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query

interface AirewaysAPI {


      @GET("qfonapp-passenger")
    fun getAirways(
          @Query("page") page: Int,
          @Query("size") size: Int
      ): Call<Aireways>
}