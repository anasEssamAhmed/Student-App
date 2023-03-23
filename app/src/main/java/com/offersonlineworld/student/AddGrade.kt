package com.offersonlineworld.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.offersonlineworld.student.Database.database
import com.offersonlineworld.student.model.student_course
import kotlinx.android.synthetic.main.activity_add_grade.*
import kotlinx.android.synthetic.main.activity_add_student.*

class AddGrade : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_grade)
        val i = database(this)
        val id = inputStudentID.text
        val semester = inputSemester2.text
        val year = inputYearOfSemester.text
        val grade = inputGradeOfCourse.text
        var courseName = ""
        val array = i.getcourse()
        val arrayAdapter = ArrayAdapter<String>(this , android.R.layout.simple_spinner_dropdown_item , array)
        spinner_Select_Course2.adapter = arrayAdapter
        spinner_Select_Course2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                courseName = array[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        btn_AddGrade.setOnClickListener {
            val isTrue = i.insertGrade("$id" , "$semester" , "$year" , "$grade" , "$courseName")
            if (isTrue){
                val s = i.getIDAndCourse("$id" , "$courseName" , "$year" , "$semester")
               if (s) {
                        i.UpdateStudenCourse("$id" , "$id" , "$courseName" , "$year" , "$semester","$grade")
                        Toast.makeText(this , "Student $id added" , Toast.LENGTH_SHORT).show()

             }else {}
            }else{
                Toast.makeText(this , "Add Failed" , Toast.LENGTH_SHORT).show()
            }
        }


    }
}