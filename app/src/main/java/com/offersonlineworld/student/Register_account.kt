package com.offersonlineworld.student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.offersonlineworld.student.Database.database
import kotlinx.android.synthetic.main.activity_register_account.*

class Register_account : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_account)
        Login.setOnClickListener {
            val intent = Intent(this , MainActivity :: class.java)
            startActivity(intent)
            finish()
        }
        val name = input_fullname.text
        val email = input_email2.text
        val password = input_password2.text
        val i = database(this)
        btn_register.setOnClickListener {
            val checkEmail = i.getEmail("$email")
            if (checkEmail){
                Toast.makeText(this , "Email is available. Please login" , Toast.LENGTH_SHORT).show()
            }else{
                val insertData = i.insertInfo("$name","$email","$password")
                Toast.makeText(this , "successfully registered" , Toast.LENGTH_SHORT).show()
                val intent = Intent(this , MainActivity :: class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}