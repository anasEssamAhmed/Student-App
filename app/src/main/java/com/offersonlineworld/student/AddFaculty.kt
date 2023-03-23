package com.offersonlineworld.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.offersonlineworld.student.Database.database
import kotlinx.android.synthetic.main.activity_add_faculty.*

class AddFaculty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_faculty)
        val i = database(this)
        val FacultyName = inputFacultyName.text
        val price = inputFacultyPriceOfHour.text
        btn_AddFaculty.setOnClickListener {
            val IsTrue = i.insertFaculty("$FacultyName" , "$price")
            if (IsTrue){
                Toast.makeText(this , "Add Successfully" , Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this , "Add Failed" , Toast.LENGTH_SHORT).show()
            }
        }

    }
}