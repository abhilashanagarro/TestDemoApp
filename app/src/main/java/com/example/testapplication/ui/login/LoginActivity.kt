package com.example.testapplication.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.testapplication.R
import com.example.testapplication.databinding.ActivityLoginBinding
import com.example.testapplication.ui.AppUtils
import com.example.testapplication.ui.Constants
import com.example.testapplication.data.LoginRequest
import com.example.testapplication.ui.home.HomeActivity


class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    private var email: String = ""
    private var password: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.btnLogin.setOnClickListener(this)
    }


    private fun validate(): Boolean {
        email = binding.edtUsername.text.toString().trim()
        password = binding.edtPassword.text.toString().trim()

        if (!AppUtils.isEmailValid(email)) {
            Toast.makeText(this, "Please enter a valid email.", Toast.LENGTH_SHORT).show()
            return false
        } else if (!AppUtils.isPasswordValid(password)) {
            Toast.makeText(this,"Please enter a valid password.", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_login -> {
                Log.d("Login", "clicked")
                if (validate()) {
                    var loginRequest = LoginRequest(email ,password)
                    var bundle = Bundle().apply {
                        putSerializable(Constants.DATA_VAL, loginRequest)

                    }
                    var intent = Intent(this, HomeActivity::class.java).apply {
                        putExtra(Constants.DATA_BUNDLE, Bundle().apply {
                            putSerializable(Constants.DATA_VAL, loginRequest)
                        })
                        startActivity(this)
                    }

                } else {
                    Log.d("Login", "Wrong input values")

                }
            }
            else -> {
                Log.d("Invalid", "Invalid input ")
            }
        }
    }
}