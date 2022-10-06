package com.example.chapter5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chapter5.databinding.ActivityLoginBinding
import com.example.chapter5.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding : ActivityRegisterBinding
    lateinit var shared : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shared = getSharedPreferences("datauser", Context.MODE_PRIVATE)

        binding.btnDaftar.setOnClickListener {

            var getEmail = binding.registEmail.text.toString()
            var getUser = binding.registUser.text.toString()
            var getPw = binding.inputRegistPw.text.toString()
            var getUpw = binding.inputRegistUpw.text.toString()

            var addDataUser = shared.edit()
            addDataUser.putString("email",getEmail)
            addDataUser.putString("user",getUser)
            addDataUser.putString("password",getPw)
            addDataUser.putString("ulangpassword",getUpw)
            addDataUser.apply()

            if (getEmail == "" && getUser == "" || getPw == "" || getUpw == ""){
                Toast.makeText(this,"Isi Lengkap Form Registrasi Terlebih Dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (getUser == ""){
                Toast.makeText(this,"Isi Lengkap Form Registrasi Terlebih Dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (getPw == ""){
                Toast.makeText(this,"Isi Lengkap Form Registrasi Terlebih Dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (getUpw == ""){
                Toast.makeText(this,"Isi Lengkap Form Registrasi Terlebih Dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                startActivity(Intent(this,LoginActivity::class.java))
            }



            Toast.makeText(this,"Terimakasih Anda Telah Registrasi", Toast.LENGTH_SHORT).show()

        }


    }
}