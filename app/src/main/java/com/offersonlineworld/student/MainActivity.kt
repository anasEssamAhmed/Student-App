package com.offersonlineworld.student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.offersonlineworld.student.Database.database
import kotlinx.android.synthetic.main.activity_addcourse.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val i = database(this)
        // Button to switch to the account registration interface
        create_account.setOnClickListener {
            val intent = Intent(this , Register_account :: class.java)
            startActivity(intent)
            finish()
        }
        val email = input_email.text
        val password = input_password.text
        btn_Login.setOnClickListener {
            val getEmailAndPassword = i.getEmailPassword("$email" , "$password")
            if (getEmailAndPassword) {
                Toast.makeText(this, "You are logged in successfully", Toast.LENGTH_LONG).show()
                val intent = Intent(this , home :: class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Wrong password or email", Toast.LENGTH_LONG).show()
            }
        }

    }
    }
