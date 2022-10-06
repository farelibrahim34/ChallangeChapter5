package com.example.chapter5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter5.adapter.MhsAdapter
import com.example.chapter5.databinding.ActivityHomeBinding
import com.example.chapter5.databinding.ActivityLoginBinding
import com.example.chapter5.model.ResponseDataMhsItem
import com.example.chapter5.network.APIMahasiswa
import com.example.chapter5.viewmodel.ViewModelDataMhs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class HomeActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomeBinding
    lateinit var viewModel :ViewModelDataMhs
    lateinit var shared : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shared = getSharedPreferences("datauser", Context.MODE_PRIVATE)

        var getUsername = shared.getString("user","")
        binding.txtUsername.text = "Welcome "+getUsername

        binding.btnProfile.setOnClickListener {
            startActivity(Intent(this,ProfileActivity::class.java))
        }
        dataMhs()

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this,AddActivity::class.java)
            startActivity(intent)
        }

    }

    fun dataMhs(){
//        APIMahasiswa.instance.getAllDataMhs()
//            .enqueue(object : Callback<List<ResponseDataMhsItem>>{
//                override fun onResponse(
//                    call: Call<List<ResponseDataMhsItem>>,
//                    response: Response<List<ResponseDataMhsItem>>
//                ) {
//                    if (response.isSuccessful){
//                        binding.rvList.layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.VERTICAL,false)
//                        binding.rvList.adapter = MhsAdapter(response.body()!!)
//                    }else{
//                        Toast.makeText(this@HomeActivity, "Load Data Failed", Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//                override fun onFailure(call: Call<List<ResponseDataMhsItem>>, t: Throwable) {
//                    Toast.makeText(this@HomeActivity, "Load Data Failed", Toast.LENGTH_SHORT).show()
//                }
//
//            })
        viewModel = ViewModelProvider(this).get(ViewModelDataMhs::class.java)
        viewModel.getDataMhs().observe(this,{
            if (it != null){
                binding.rvList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                val adapter = MhsAdapter(it)
                binding.rvList.adapter = adapter
            }
        })
        viewModel.callApiDataMhs()
    }
}