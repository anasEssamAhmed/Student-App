package com.offersonlineworld.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.offersonlineworld.student.Database.database
import kotlinx.android.synthetic.main.activity_add_course2.*

class AddCourse2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course2)
        val i =  database(this)
        val ID = inputIDCourse.text
        val name = inputCourseName.text
        val hour = inputCourseHoursNumber.text
        btn_AddCourse2.setOnClickListener {
            val isTrue = i.insertCourse("$ID" , "$name" , "$hour")
            if (isTrue){
                Toast.makeText(this , "Add Successfully" , Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this , "Add Failed" , Toast.LENGTH_SHORT).show()
            }
        }
    }
}