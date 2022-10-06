package com.example.chapter5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chapter5.databinding.ActivityHomeBinding
import com.example.chapter5.databinding.ActivityProfileBinding
import com.example.chapter5.databinding.ActivityRegisterBinding

class ProfileActivity : AppCompatActivity() {

    lateinit var binding : ActivityProfileBinding
    lateinit var shared : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_profile)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shared = getSharedPreferences("datauser", Context.MODE_PRIVATE)

        var getUsername = shared.getString("user","")
        binding.profileUser.setText(getUsername)
        var getNama = shared.getString("nama","")
        binding.inputNama.setText(getNama)
        var getAlamat = shared.getString("alamat","")
        binding.inputAlamat.setText(getAlamat)
        var getTgl = shared.getString("tgl","")
        binding.inputTgl.setText(getTgl)






        binding.btnUpdateProfile.setOnClickListener {
            var inNama = binding.inputNama.text.toString()
            var inAlamat = binding.inputAlamat.text.toString()
            var inTgl = binding.inputTgl.text.toString()

            var addProfil = shared.edit()

            addProfil.putString("nama",inNama)
            addProfil.putString("alamat",inAlamat)
            addProfil.putString("tgl",inTgl)
            addProfil.apply()

            startActivity(Intent(this,HomeActivity::class.java))
            Toast.makeText(this,"Anda Berhasil Update Profile", Toast.LENGTH_SHORT).show()
        }
        binding.btnLogout.setOnClickListener {
            val pref = shared.edit()
            pref.clear()
            pref.apply()
            startActivity(Intent(this,LoginActivity::class.java))
            Toast.makeText(this,"Anda Berhasil Logout", Toast.LENGTH_SHORT).show()
        }


    }
}