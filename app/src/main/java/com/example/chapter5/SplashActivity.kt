package com.example.chapter5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.chapter5.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var binding : ActivitySplashBinding
    lateinit var shared : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val splashTime: Long = 3000 // lama splashscreen berjalan

//        Handler().postDelayed({
//            shared = getSharedPreferences("datauser",Context.MODE_PRIVATE)
//            if (shared.getString("email","").equals("")){
//                var intent = Intent(this, LoginActivity::class.java)
//                startActivity(intent)
//                finish()
//
//            }else if(shared.getString("email","")!!.length !=0){
//                var intent = Intent(this, HomeActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//        }, splashTime)

        Handler(Looper.myLooper()!!).postDelayed({
            shared = getSharedPreferences("datauser",Context.MODE_PRIVATE)
            if (shared.getString("email","").equals("")){
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            }else if (shared.getString("email","")!!.length !=0){
                startActivity(Intent(this,HomeActivity::class.java))
                finish()

            }
        },3000)






    }
}