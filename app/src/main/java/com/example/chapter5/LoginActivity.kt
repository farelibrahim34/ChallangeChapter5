package com.example.chapter5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chapter5.databinding.ActivityLoginBinding
import com.example.chapter5.databinding.ActivitySplashBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    lateinit var shared : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shared = getSharedPreferences("datauser", Context.MODE_PRIVATE)

        binding.txtRegis.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {

            var getDataEmail = shared.getString("email","")
            var getDataPw = shared.getString("password","")

            var email = binding.inputEmail.text.toString()
            var pw = binding.inputPw.text.toString()

            if (email.isEmpty() || pw.isEmpty()){
                Toast.makeText(this,"ISI PASSWORD DAN USERNAME ANDA", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }else if (email == getDataEmail.toString() && pw == getDataPw.toString()){
                startActivity(Intent(this,HomeActivity::class.java))
                Toast.makeText(this,"Anda Berhasil Login", Toast.LENGTH_SHORT).show()

            }else if (email != getDataEmail.toString() || pw != getDataPw.toString()){
                Toast.makeText(this,"USERNAME DAN PASSWORD ANDA SALAH", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

        }


    }
}