package com.offersonlineworld.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.offersonlineworld.student.Database.database
import kotlinx.android.synthetic.main.activity_add_student.*
import kotlinx.android.synthetic.main.activity_addcourse.*

class addcourse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcourse)
        val i = database(this)
        val id = intent.getStringExtra("id")
        student_id.text = id
        val year = input_year.text
        val semester = input_semester.text
        var course = ""
        val array = i.getcourse()
        val arrayAdapter = ArrayAdapter<String>(this , android.R.layout.simple_spinner_dropdown_item , array)
        spinner_course.adapter = arrayAdapter
        spinner_course.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                course = array[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        btn_addCourse.setOnClickListener {
            val IsTrue = i.insertStudent_course("${this.student_id.text}" , "$course" , "$year" , "$semester" , "not evaluate")
            if (IsTrue){
                Toast.makeText(this , "Add Successfully" , Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this , "Add Failed" , Toast.LENGTH_SHORT).show()
            }
        }


    }
}