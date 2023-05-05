package com.shashank.qfonproject.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shashank.qfonproject.data.api.AirewaysAPI
import com.shashank.qfonproject.data.model.Aireways
import com.shashank.qfonproject.utils.NetworkResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject


class AirWaysRepository @Inject constructor(private val api: AirewaysAPI){

    private  val  _AirwaysLiveData = MutableLiveData<NetworkResponse<Aireways>>()
    val AirwaysLiveData:LiveData<NetworkResponse<Aireways>>
     get() = _AirwaysLiveData


    fun  getAirwaysList(page:Int,size:Int){

        try {
            val response = api.getAirways(page,size)

            response.enqueue(object : Callback<Aireways>{
                override fun onResponse(call: Call<Aireways>, response: Response<Aireways>) {
                    Log.d("MYAPP", response.body().toString())
                 _AirwaysLiveData.postValue(NetworkResponse.Success(response.body()!!))

                }

                override fun onFailure(call: Call<Aireways>, t: Throwable) {
                    Log.d("MYAPP", t.localizedMessage!!.toString())
                    _AirwaysLiveData.postValue(NetworkResponse.Failure(t.localizedMessage!!.toString()))

                }


            })
        }catch (e:Exception){

            Log.d("MYAPP", e.localizedMessage!!.toString())

        }
    }


}