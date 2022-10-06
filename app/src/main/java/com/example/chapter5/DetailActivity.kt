package com.example.chapter5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.chapter5.databinding.ActivityDetailBinding
import com.example.chapter5.model.ResponseDataMhsItem
import com.example.chapter5.viewmodel.ViewModelDataMhs
import kotlin.properties.Delegates

class DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailBinding
    lateinit var viewModel : ViewModelDataMhs
    var id by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(ViewModelDataMhs::class.java)
        id = intent.getStringExtra("id")!!.toInt()
        Log.d("DEBUG_ID",id.toString())
        setDetail()



    }
    fun setDetail(){

        viewModel.callGetDataMhs(id)
        viewModel.getDataMhs(id).observe(this,{
            binding.detailNama.setText("Nama : "+ it!!.nama)
            binding.detailNim.setText("Nim : "+ it!!.nim)
            binding.detailJk.setText("Jenis Kelamin : "+ it!!.jk)
            binding.detailAlamat.setText("Alamat : "+ it!!.alamat)
//            Glide.with(holder.itemView).load(listData[position].foto).into(holder.binding.imgMhs)
            var url = it.foto
            Glide.with(this).load(url).into(binding.imgDetail)



        })
    }
}