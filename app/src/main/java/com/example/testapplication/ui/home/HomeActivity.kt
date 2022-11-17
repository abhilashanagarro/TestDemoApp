package com.example.testapplication.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.testapplication.R
import com.example.testapplication.data.LoginRequest
import com.example.testapplication.databinding.ActivityHomeBinding
import com.example.testapplication.ui.Constants
class HomeActivity : AppCompatActivity(){

    private lateinit var binding: ActivityHomeBinding
    private var loginRequest:LoginRequest? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        var bundle = intent.getBundleExtra(Constants.DATA_BUNDLE)
        bundle.let {
            Log.d("Log" ,"")
            loginRequest = it?.getSerializable(Constants.DATA_VAL) as LoginRequest?
            binding.tvUsername.text = " Email : ${loginRequest?.email}"
            binding.tvPassword.text = " Password : ${loginRequest?.password}"
        }
    }
}