package com.shashank.qfonproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.shashank.qfonproject.adapter.AirwaysAdapter
import com.shashank.qfonproject.data.viewmodel.AirwaysViewModel
import com.shashank.qfonproject.databinding.ActivityMainBinding
import com.shashank.qfonproject.utils.NetworkResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private  val viewModel by viewModels<AirwaysViewModel>()
    private  var _binding :ActivityMainBinding? = null
    private  val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)





        setContentView(binding.root)
            viewModel.getAirwaysLiveData(1,10)

        viewModel.airWaysLiveData.observe(this){
            when(it){
                is NetworkResponse.Success ->{
                    Log.d("ADAPTER =","${it.data!!}")

                  val  adapter = AirwaysAdapter(it.data.data)
                    binding.recyclerView.layoutManager =LinearLayoutManager(this)

                binding.recyclerView.adapter =adapter
                }
                is NetworkResponse.Failure ->{

                }
                is NetworkResponse.Loading ->{

                }
            }
        }



    }
}